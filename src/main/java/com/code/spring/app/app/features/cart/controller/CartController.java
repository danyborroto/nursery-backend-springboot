package com.code.spring.app.app.features.cart.controller;

import com.code.spring.app.app.features.cart.dto.CartCreateDto;
import com.code.spring.app.app.features.cart.dto.CartResponseDto;
import com.code.spring.app.app.features.cart.service.CartService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartResponseDto> getAll() {
        return cartService.getAll();
    }

    @GetMapping("/{id}")
    public CartResponseDto getOne(@PathVariable Integer id) {
        return cartService.getOne(id);
    }

    @PostMapping
    public CartResponseDto create(@Valid @RequestBody CartCreateDto dto) {
        return cartService.create(dto);
    }

    @PutMapping("/{id}")
    public CartResponseDto update(@PathVariable Integer id, @Valid @RequestBody CartCreateDto dto) {
        return cartService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return cartService.delete(id);
    }
}
