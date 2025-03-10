package com.examly.toystore.controller;

import com.examly.toystore.model.Category;
import com.examly.toystore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

        @Autowired
            private CategoryService categoryService;

                @GetMapping
                    public List<Category> getAllCategories(Pageable pageable) {
                                return categoryService.getAllCategories(pageable);
                    }

                        @GetMapping("/{id}")
                            public Category getCategoryById(@PathVariable int id) {
                                        return categoryService.getCategoryById(id);
                            }

                                @GetMapping("/search")
                                    public List<Category> searchCategoriesByName(@RequestParam String name) {
                                                return categoryService.getCategoriesByNameContaining(name);
                                    }

                                        @PostMapping
                                            public ResponseEntity<Category> createCategory(@RequestBody Category category) {
                                                        return ResponseEntity.ok(categoryService.saveCategory(category));
                                            }

                                                @PostMapping("/bulk")
                                                    public ResponseEntity<List<Category>> createCategories(@RequestBody List<Category> categories) {
                                                                return ResponseEntity.ok(categoryService.saveAllCategories(categories));
                                                    }

                                                        @PutMapping("/{id}")
                                                            public Category updateCategory(@PathVariable int id, @RequestBody Category updatedCategory) {
                                                                        return categoryService.updateCategory(id, updatedCategory);
                                                            }

                                                                @DeleteMapping("/{id}")
                                                                    public void deleteCategory(@PathVariable int id) {
                                                                                categoryService.deleteCategory(id);
                                                                    }

                                                                        @DeleteMapping("/all")
                                                                            public void deleteAllCategories() {
                                                                                        categoryService.deleteAllCategories();
                                                                            }
                                                                        }
                                                                        