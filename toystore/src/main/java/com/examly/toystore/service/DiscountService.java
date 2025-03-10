package com.examly.toystore.service;

import com.examly.toystore.model.Discount;
import com.examly.toystore.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

        @Autowired
            private DiscountRepository discountRepository;

                public List<Discount> getAllDiscounts(Pageable pageable) {
                            return discountRepository.findAll(pageable).getContent();
                }

                    public Discount getDiscountById(int id) {
                                return discountRepository.findById(id).orElse(null);
                    }

                        public Discount saveDiscount(Discount discount) {
                                    return discountRepository.save(discount);
                        }

                            public List<Discount> saveAllDiscounts(List<Discount> discounts) {
                                        return discountRepository.saveAll(discounts);
                            }

                                public Discount updateDiscount(int id, Discount updatedDiscount) {
                                            updatedDiscount.setDiscountId(id);
                                                    return discountRepository.save(updatedDiscount);
                                }

                                    public void deleteDiscount(int id) {
                                                discountRepository.deleteById(id);
                                    }

                                        public void deleteAllDiscounts() {
                                                    discountRepository.deleteAll();
                                        }
                                            public List<Discount> findDiscountsByName(String name) {
                                                        return discountRepository.findByName(name);
                                            }

                                                public List<Discount> findDiscountsByMinimumPercentage(float minPercentage) {
                                                            return discountRepository.findByMinimumPercentage(minPercentage);
                                                }
                                            }
                                            