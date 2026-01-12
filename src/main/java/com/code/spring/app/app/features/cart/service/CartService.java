package com.code.spring.app.app.features.cart.service;

import com.code.spring.app.app.exception.CartNotFoundException;
import com.code.spring.app.app.exception.UserNotFoundException;
import com.code.spring.app.app.features.cart.dto.CartCreateDto;
import com.code.spring.app.app.features.cart.dto.CartResponseDto;
import com.code.spring.app.app.features.cart.entity.Cart;
import com.code.spring.app.app.features.cart.repository.CartRepository;
import com.code.spring.app.app.features.user.dto.UserResponseDto;
import com.code.spring.app.app.features.user.entity.User;
import com.code.spring.app.app.features.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public CartService(CartRepository cartRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public List<CartResponseDto> getAll() {
        return cartRepository.findAll().stream()
                .map(cart -> new CartResponseDto(
                        new UserResponseDto(
                                cart.getUser().getUserName(),
                                cart.getUser().getUserEmail(),
                                cart.getUser().getUserPhone()
                        ),
                        cart.getActive()
                ))
                .toList();
    }

    public CartResponseDto getOne(Integer id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
        return mapToResponseDto(cart);
    }

    public CartResponseDto create(CartCreateDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(dto.getUserId()));
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setActive(dto.getActive());
        Cart saved = cartRepository.save(cart);
        return mapToResponseDto(saved);
    }

    public CartResponseDto update(Integer id, CartCreateDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(dto.getUserId()));
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
        cart.setActive(dto.getActive());
        return mapToResponseDto(cartRepository.save(cart));
    }

    public String delete(Integer id){
        return cartRepository.findById(id)
                .map(cart->{
                    cartRepository.delete(cart);
                    return "Cart con ID: "+id+" eliminado correctamente";
                })
                .orElseThrow(()->new CartNotFoundException(id));
    }

    private CartResponseDto mapToResponseDto(Cart cart) {
        CartResponseDto dto = new CartResponseDto();
        dto.setUser(
                new UserResponseDto(
                        cart.getUser().getUserName(),
                        cart.getUser().getUserEmail(),
                        cart.getUser().getUserPhone()
                )
        );
        dto.setActive(cart.getActive());
        return dto;
    }
}
