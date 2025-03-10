package com.examly.toystore.controller;

import com.examly.toystore.model.User;
import com.examly.toystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

        @Autowired
            private UserService userService;

                @GetMapping
                    public List<User> getAllUsers(Pageable pageable) {
                                return userService.getAllUsers(pageable);
                    }

                        @GetMapping("/search/name")
                            public List<User> getUsersByName(@RequestParam String name) {
                                        return userService.getUsersByNameLike(name);
                            }
                                
                                @GetMapping("/search/email")
                                    public List<User> getUsersByEmail(@RequestParam String email) {
                                                return userService.getUsersByEmailLike(email);
                                    }
                                        
                                        @GetMapping("/{id}")
                                            public User getUserById(@PathVariable int id) {
                                                        return userService.getUserById(id);
                                            }

                                                @PostMapping
                                                    public ResponseEntity<User> createUser(@RequestBody User user) {
                                                                return ResponseEntity.ok(userService.saveUser(user));
                                                    }

                                                        @PostMapping("/bulk")
                                                            public ResponseEntity<List<User>> createUsers(@RequestBody List<User> users) {
                                                                        return ResponseEntity.ok(userService.saveAllUsers(users));
                                                            }

                                                                @PutMapping("/{id}")
                                                                    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
                                                                                return userService.updateUser(id, updatedUser);
                                                                    }

                                                                        @DeleteMapping("/{id}")
                                                                            public void deleteUser(@PathVariable int id) {
                                                                                        userService.deleteUser(id);
                                                                            }

                                                                                @DeleteMapping("/all")
                                                                                    public void deleteAllUsers() {
                                                                                                userService.deleteAllUsers();
                                                                                    }
                                                                                }
                                                                                