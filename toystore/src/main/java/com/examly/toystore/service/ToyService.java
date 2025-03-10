package com.examly.toystore.service;
import com.examly.toystore.model.Toy;
import com.examly.toystore.repository.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ToyService {

        @Autowired
            private ToyRepository toyRepository;

                public List<Toy> getAllToys(Pageable pageable) {
                            return toyRepository.findAll(pageable).getContent();
                }
                    
                    public List<Toy> getToysByCategoryLike(String category) {
                                return toyRepository.findByCategoryLike(category);
                    }
                        
                        public List<Toy> getToysByPriceRange(float minPrice, float maxPrice) {
                                    return toyRepository.findByPriceRange(minPrice, maxPrice);
                        }
                            
                            
                            public Toy getToyById(int id) {
                                        return toyRepository.findById(id).orElse(null);
                            }
                                
                                public List<Toy> saveAllToys(List<Toy> toys) {
                                            return toyRepository.saveAll(toys);
                                }
                                    
                                    public void deleteToy(int id) {
                                                toyRepository.deleteById(id);
                                    }
                                        public void deleteAllToys() {
                                                    toyRepository.deleteAll();
                                        }

                                            public Toy updateToy(int id, Toy updatedToy) {
                                                        return toyRepository.findById(id).map(toy -> {
                                                                        toy.setName(updatedToy.getName());
                                                                                    toy.setPrice(updatedToy.getPrice());
                                                                                                toy.setCategory(updatedToy.getCategory());
                                                                                                            return toyRepository.save(toy);
                                                        }).orElse(null);
                                                    }
                                                        public Toy saveToy(Toy toy) {
                                                                    return toyRepository.save(toy);
                                                        }
                                                            
                                                            public List<Toy> searchToys(String keyword) {
                                                                        return toyRepository.searchByName(keyword);
                                                            }
                                                        }
                                                        