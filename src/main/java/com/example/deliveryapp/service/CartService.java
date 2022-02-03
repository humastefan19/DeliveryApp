package com.example.deliveryapp.service;

import com.example.deliveryapp.model.Cart;
import com.example.deliveryapp.model.CustomerOrder;
import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.repository.CartRepository;
import com.example.deliveryapp.repository.OrderRepository;
import com.example.deliveryapp.repository.ProductRepository.ProductRepository;
import com.example.deliveryapp.security.SecurityService;
import com.example.deliveryapp.utils.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final SecurityService securityService;
    private final ProductRepository productRepository;

    public Cart addProductToCart(Long productId){
        CustomerOrder customerOrder= orderRepository.getCurrentCustomerOrder(securityService.getCurrentUserId(), OrderStatus.NOT_ORDER);
        Product product = productRepository.getById(productId);
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setOrder(customerOrder);
        return cartRepository.save(cart);
    }






}
