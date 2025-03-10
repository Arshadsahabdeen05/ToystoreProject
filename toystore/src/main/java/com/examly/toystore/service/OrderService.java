package com.examly.toystore.service;

import com.examly.toystore.model.Order;
import com.examly.toystore.repository.OrderRepository;

import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
        private final OrderRepository orderRepository;

            public OrderService(OrderRepository orderRepository) {
                        this.orderRepository = orderRepository;
            }

                public List<Order> getAllOrders(Pageable pageable) {
                            return orderRepository.findAll(pageable).getContent();
                }

                    public Order getOrderById(int id) {
                                return orderRepository.findById(id).orElse(null);
                    }

                        public List<Order> getOrdersByStatus(String status) {
                                    return orderRepository.findByStatus(status);
                        }
                            
                            public List<Order> getOrdersByMinimumAmount(float minAmount) {
                                        return orderRepository.findByMinimumAmount(minAmount);
                            }
                                

                                public Order saveOrder(Order order) {
                                            return orderRepository.save(order);
                                }

                                    public Order updateOrder(int id, Order updatedOrder) {
                                                return orderRepository.findById(id).map(order -> {
                                                                order.setOrderDate(updatedOrder.getOrderDate());
                                                                            order.setTotalAmount(updatedOrder.getTotalAmount());
                                                                                        order.setStatus(updatedOrder.getStatus());
                                                                                                    return orderRepository.save(order);
                                                }).orElse(null);
                                            }

                                                public void deleteOrder(int id) {
                                                            orderRepository.deleteById(id);
                                                }
                                            }
                                            