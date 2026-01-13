package com.code.spring.app.app.features.cartproducto.controller;

import com.code.spring.app.app.features.cartproducto.dto.CartProductCreateDto;
import com.code.spring.app.app.features.cartproducto.dto.CartProductResponseDto;
import com.code.spring.app.app.features.cartproducto.service.CartProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts/{cartId}/products")
public class CartProductController {
    private final CartProductService cartProductService;

    public CartProductController(CartProductService cartProductService) {
        this.cartProductService = cartProductService;
    }
    /*
    @GetMapping
    public List<CartProductResponseDto> getAll(){
        return cartProductService.getAll();
    }*/

    @GetMapping
    public List<CartProductResponseDto> getAllByCart(@PathVariable Integer cartId) {
        return cartProductService.getAllByCart(cartId);
    }

    @GetMapping("/{productId}")
    public CartProductResponseDto getOne(@PathVariable Integer cartId, @PathVariable Integer productId) {
        CartProductResponseDto cartProductResponseDto = cartProductService.getOne(cartId, productId);
        return cartProductResponseDto;
    }

    @PostMapping("/{productId}")
    public CartProductResponseDto create(@PathVariable Integer cartId,
                                         @PathVariable Integer productId,
                                         @Valid @RequestBody CartProductCreateDto cartProductCreateDto){
        return cartProductService.create(cartId,productId,cartProductCreateDto);
    }

    @PutMapping("/{productId}")
    public CartProductResponseDto update(@PathVariable Integer cartId,
                                         @PathVariable Integer productId,
                                         @Valid @RequestBody CartProductCreateDto dto){
        return cartProductService.update(cartId,productId,dto);
    }

    @DeleteMapping("/{productId}")
    public String delete(@PathVariable Integer cartId,
                         @PathVariable Integer productId){
        return cartProductService.delete(cartId,productId);
    }
}
