package com.examly.toystore.service;

import com.examly.toystore.model.Category;
import com.examly.toystore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

        @Autowired
            private CategoryRepository categoryRepository;

                public List<Category> getAllCategories(Pageable pageable) {
                            return categoryRepository.findAll(pageable).getContent();
                }

                    public Category getCategoryById(int id) {
                                return categoryRepository.findById(id).orElse(null);
                    }

                        public List<Category> getCategoriesByNameContaining(String name) {
                                    return categoryRepository.findByNameContaining(name);
                        }

                            public Category saveCategory(Category category) {
                                        return categoryRepository.save(category);
                            }

                                public List<Category> saveAllCategories(List<Category> categories) {
                                            return categoryRepository.saveAll(categories);
                                }

                                    public Category updateCategory(int id, Category updatedCategory) {
                                                updatedCategory.setId(id);
                                                        return categoryRepository.save(updatedCategory);
                                    }

                                        public void deleteCategory(int id) {
                                                    categoryRepository.deleteById(id);
                                        }

                                            public void deleteAllCategories() {
                                                        categoryRepository.deleteAll();
                                            }
                                        }
                                        