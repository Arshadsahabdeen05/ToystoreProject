package com.examly.toystore.controller;
import com.examly.toystore.model.Toy;
import com.examly.toystore.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toys")
public class ToyController {

        @Autowired
            private ToyService toyService;

                @GetMapping
                    public List<Toy> getAllToys(Pageable pageable) {
                                return toyService.getAllToys(pageable);
                    }
                        @GetMapping("/category")
                        public List<Toy> getToysByCategory(@RequestParam String category) {
                                return toyService.getToysByCategoryLike(category);
                        }

                        @GetMapping("/price-range")
                        public List<Toy> getToysByPriceRange(@RequestParam float minPrice, @RequestParam float maxPrice) {
                                return toyService.getToysByPriceRange(minPrice, maxPrice);
                        }


                            @GetMapping("/{id}")
                                public Toy getToyById(@PathVariable int id) {
                                            return toyService.getToyById(id);
                                }

                                    @GetMapping("/search")
                                        public List<Toy> searchToys(@RequestParam String keyword) {
                                                    return toyService.searchToys(keyword);
                                        }
                                            @PostMapping
                                            public ResponseEntity<Toy> createToy(@RequestBody Toy toy) {
                                                    return ResponseEntity.ok(toyService.saveToy(toy));
                                            }


                                            @PostMapping("/bulk")
                                            public ResponseEntity<List<Toy>> createToys(@RequestBody List<Toy> toys) {
                                                    List<Toy> savedToys = toyService.saveAllToys(toys);
                                                        return ResponseEntity.ok(savedToys);
                                            }


                                                @PutMapping("/{id}")
                                                    public Toy updateToy(@PathVariable int id, @RequestBody Toy updatedToy) {
                                                                return toyService.updateToy(id, updatedToy);
                                                    }

                                                        @DeleteMapping("/{id}")
                                                            public void deleteToy(@PathVariable int id) {
                                                                        toyService.deleteToy(id);
                                                            }
                                                                @DeleteMapping("/all")
                                                                    public void deleteAllToys() {
                                                                                toyService.deleteAllToys();
                                                                    }
                                                                }