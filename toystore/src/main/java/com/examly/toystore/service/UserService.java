package com.examly.toystore.service;

import com.examly.toystore.model.User;
import com.examly.toystore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

        @Autowired
            private UserRepository userRepository;

                public List<User> getAllUsers(Pageable pageable) {
                            return userRepository.findAll(pageable).getContent();
                }
                    public List<User> getUsersByNameLike(String name) {
                                return userRepository.findByNameLike(name);
                    }
                        
                        public List<User> getUsersByEmailLike(String email) {
                                    return userRepository.findByEmailLike(email);
                        }
                            

                            public User getUserById(int id) {
                                        return userRepository.findById(id).orElse(null);
                            }

                                public User saveUser(User user) {
                                            return userRepository.save(user);
                                }

                                    public List<User> saveAllUsers(List<User> users) {
                                                return userRepository.saveAll(users);
                                    }

                                        public User updateUser(int id, User updatedUser) {
                                                    updatedUser.setUserId(id);
                                                            return userRepository.save(updatedUser);
                                        }

                                            public void deleteUser(int id) {
                                                        userRepository.deleteById(id);
                                            }

                                                public void deleteAllUsers() {
                                                            userRepository.deleteAll();
                                                }
                                            }
                                            