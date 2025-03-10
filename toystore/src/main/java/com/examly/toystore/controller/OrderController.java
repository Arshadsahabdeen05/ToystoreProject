package com.examly.toystore.controller;

import com.examly.toystore.model.Order;
import com.examly.toystore.service.OrderService;

import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
        private final OrderService orderService;

            public OrderController(OrderService orderService) {
                        this.orderService = orderService;
            }

                @GetMapping
                    public List<Order> getAllOrders(Pageable pageable) {
                                return orderService.getAllOrders(pageable);
                    }

                        @GetMapping("/{id}")
                            public Order getOrderById(@PathVariable int id) {
                                        return orderService.getOrderById(id);
                            }

                                @GetMapping("/status")
                                public List<Order> getOrdersByStatus(@RequestParam String status) {
                                        return orderService.getOrdersByStatus(status);
                                }

                                @GetMapping("/min-amount")
                                public List<Order> getOrdersByMinimumAmount(@RequestParam float minAmount) {
                                        return orderService.getOrdersByMinimumAmount(minAmount);
                                }


                                    @PostMapping
                                        public ResponseEntity<Order> createOrder(@RequestBody Order order) {
                                                    return ResponseEntity.ok(orderService.saveOrder(order));
                                        }

                                            @PutMapping("/{id}")
                                                public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order updatedOrder) {
                                                            Order order = orderService.updateOrder(id, updatedOrder);
                                                                    return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
                                                }

                                                    @DeleteMapping("/{id}")
                                                        public ResponseEntity<Void> deleteById(@PathVariable int id) {
                                                                    orderService.deleteOrder(id);
                                                                            return ResponseEntity.noContent().build();
                                                        }
                                                    }
                                                    