package com.example.cartapi.service;

import com.example.cartapi.model.Cart;
import com.example.cartapi.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addItem(Long userId, Cart cart) {
        cart.setUserId(userId);
        return cartRepository.save(cart);
    }

    public List<Cart> getCartByUser(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart updateItem(Long itemId, Cart updatedCart) {
        Cart cart = cartRepository.findById(itemId).orElseThrow();
        cart.setQuantity(updatedCart.getQuantity());
        return cartRepository.save(cart);
    }

    public void removeItem(Long itemId) {
        cartRepository.deleteById(itemId);
    }
}
