package com.example.cartapi.controller;

import com.example.cartapi.model.Cart;
import com.example.cartapi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}/add")
    public Cart addItem(@PathVariable Long userId, @RequestBody Cart cart) {
        return cartService.addItem(userId, cart);
    }

    @GetMapping("/{userId}")
    public List<Cart> viewCart(@PathVariable Long userId) {
        return cartService.getCartByUser(userId);
    }

    @PutMapping("/update/{itemId}")
    public Cart updateItem(@PathVariable Long itemId, @RequestBody Cart cart) {
        return cartService.updateItem(itemId, cart);
    }

    @DeleteMapping("/remove/{itemId}")
    public void removeItem(@PathVariable Long itemId) {
        cartService.removeItem(itemId);
    }
}
