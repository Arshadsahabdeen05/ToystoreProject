package com.examly.toystore.service;

import com.examly.toystore.model.Cart;
import com.examly.toystore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

        @Autowired
            private CartRepository cartRepository;

                public List<Cart> getAllCarts(Pageable pageable) {
                            return cartRepository.findAll(pageable).getContent();
                }

                    public Cart getCartById(int id) {
                                return cartRepository.findById(id).orElse(null);
                    }

                        public List<Cart> getCartsByMinimumQuantity(int minQuantity) {
                                    return cartRepository.findByMinimumQuantity(minQuantity);
                        }
                            public Cart saveCart(Cart cart) {
                                        return cartRepository.save(cart);
                            }

                                public List<Cart> saveAllCarts(List<Cart> carts) {
                                            return cartRepository.saveAll(carts);
                                }

                                    public Cart updateCart(int id, Cart updatedCart) {
                                                updatedCart.setCartId(id);
                                                        return cartRepository.save(updatedCart);
                                    }

                                        public void deleteCart(int id) {
                                                    cartRepository.deleteById(id);
                                        }

                                            public void deleteAllCarts() {
                                                        cartRepository.deleteAll();
                                            }
                                        }
                                        