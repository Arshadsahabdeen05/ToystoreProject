package com.examly.toystore.controller;

import com.examly.toystore.model.Cart;
import com.examly.toystore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

        @Autowired
            private CartService cartService;

                @GetMapping
                    public List<Cart> getAllCarts(Pageable pageable) {
                                return cartService.getAllCarts(pageable);
                    }
                        
                        @GetMapping("/{id}")
                            public Cart getCartById(@PathVariable int id) {
                                        return cartService.getCartById(id);
                            }

                                @GetMapping("/min-quantity")
                                    public List<Cart> getCartsByMinQuantity(@RequestParam int value) {
                                                return cartService.getCartsByMinimumQuantity(value);
                                    }
                                        @PostMapping
                                            public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
                                                        return ResponseEntity.ok(cartService.saveCart(cart));
                                            }

                                                @PostMapping("/bulk")
                                                    public ResponseEntity<List<Cart>> createCarts(@RequestBody List<Cart> carts) {
                                                                return ResponseEntity.ok(cartService.saveAllCarts(carts));
                                                    }

                                                        @PutMapping("/{id}")
                                                            public Cart updateCart(@PathVariable int id, @RequestBody Cart updatedCart) {
                                                                        return cartService.updateCart(id, updatedCart);
                                                            }

                                                                @DeleteMapping("/{id}")
                                                                    public void deleteCart(@PathVariable int id) {
                                                                                cartService.deleteCart(id);
                                                                    }

                                                                        @DeleteMapping("/all")
                                                                            public void deleteAllCarts() {
                                                                                        cartService.deleteAllCarts();
                                                                            }
    }
                                                                        