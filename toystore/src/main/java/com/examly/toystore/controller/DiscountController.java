package com.examly.toystore.controller;

import com.examly.toystore.model.Discount;
import com.examly.toystore.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

        @Autowired
            private DiscountService discountService;

                @GetMapping
                    public List<Discount> getAllDiscounts(Pageable pageable) {
                                return discountService.getAllDiscounts(pageable);
                    }

                        @GetMapping("/{id}")
                            public Discount getDiscountById(@PathVariable int id) {
                                        return discountService.getDiscountById(id);
                            }

                                @PostMapping
                                    public ResponseEntity<Discount> createDiscount(@RequestBody Discount discount) {
                                                return ResponseEntity.ok(discountService.saveDiscount(discount));
                                    }

                                        @PostMapping("/bulk")
                                            public ResponseEntity<List<Discount>> createDiscounts(@RequestBody List<Discount> discounts) {
                                                        return ResponseEntity.ok(discountService.saveAllDiscounts(discounts));
                                            }

                                                @PutMapping("/{id}")
                                                    public Discount updateDiscount(@PathVariable int id, @RequestBody Discount updatedDiscount) {
                                                                return discountService.updateDiscount(id, updatedDiscount);
                                                    }

                                                        @DeleteMapping("/{id}")
                                                            public void deleteDiscount(@PathVariable int id) {
                                                                        discountService.deleteDiscount(id);
                                                            }

                                                                @DeleteMapping("/all")
                                                                    public void deleteAllDiscounts() {
                                                                                discountService.deleteAllDiscounts();
                                                                    }
                                                                        @GetMapping("/search")
                                                                            public List<Discount> findDiscountsByName(@RequestParam String name) {
                                                                                        return discountService.findDiscountsByName(name);
                                                                            }

                                                                                @GetMapping("/min-percentage")
                                                                                    public List<Discount> findDiscountsByMinimumPercentage(@RequestParam float minPercentage) {
                                                                                                return discountService.findDiscountsByMinimumPercentage(minPercentage);
                                                                                    }
                                                                                }                                                                              