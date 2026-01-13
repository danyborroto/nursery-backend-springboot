package com.code.spring.app.app.features.cartproducto.service;

import com.code.spring.app.app.exception.CartNotFoundException;
import com.code.spring.app.app.exception.CartProductNotFoundException;
import com.code.spring.app.app.exception.ProductoNotFounException;
import com.code.spring.app.app.features.cart.entity.Cart;
import com.code.spring.app.app.features.cart.repository.CartRepository;
import com.code.spring.app.app.features.cartproducto.dto.CartProductCreateDto;
import com.code.spring.app.app.features.cartproducto.dto.CartProductResponseDto;
import com.code.spring.app.app.features.cartproducto.entity.CartProduct;
import com.code.spring.app.app.features.cartproducto.entity.CartProductId;
import com.code.spring.app.app.features.cartproducto.repository.CartProductRepository;
import com.code.spring.app.app.features.producto.entity.Producto;
import com.code.spring.app.app.features.producto.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartProductService {
    private final CartProductRepository cartProductRepository;
    private final CartRepository cartRepository;
    private final ProductoRepository productoRepository;

    public CartProductService(CartProductRepository cartProductRepository, CartRepository cartRepository,
                              ProductoRepository productoRepository) {
        this.cartProductRepository = cartProductRepository;
        this.cartRepository = cartRepository;
        this.productoRepository = productoRepository;
    }

    public List<CartProductResponseDto> getAll() {
        return cartProductRepository.findAll().stream()
                .map(cartProduct -> new CartProductResponseDto(
                        cartProduct.getProducto().getId(),
                        cartProduct.getProducto().getNombre(),
                        cartProduct.getPrice(),
                        cartProduct.getCount()
                ))
                .toList();
    }
    public List<CartProductResponseDto> getAllByCart(Integer cartId) {
        return cartProductRepository.findByCart_CartId(cartId).stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    public CartProductResponseDto getOne(Integer cartId, Integer productId) {
        CartProductId cartProductId = new CartProductId(cartId, productId);
        CartProduct cartProduct = cartProductRepository.findById(cartProductId)
                .orElseThrow(() -> new CartProductNotFoundException(cartId, productId));
        return mapToResponseDto(cartProduct);
    }

    public CartProductResponseDto create(Integer cartId, Integer productId, CartProductCreateDto dto) {
        CartProductId cartProductId = new CartProductId(cartId, productId);
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));
        Producto producto = productoRepository.findById(productId)
                .orElseThrow(() -> new ProductoNotFounException(productId));
        Optional<CartProduct> existing = cartProductRepository.findById(cartProductId);
        CartProduct cartProduct = new CartProduct();
        if (existing.isPresent()) {
            existing.get().setCount(existing.get().getCount() + dto.getQuantity());
            cartProduct = cartProductRepository.save(existing.get());
        } else {
            cartProduct.setId(cartProductId);
            cartProduct.setCart(cart);
            cartProduct.setPrice(producto.getPrecio());
            cartProduct.setCount(dto.getQuantity());
        }

        CartProduct saved = cartProductRepository.save(cartProduct);
        return mapToResponseDto(saved);
    }

    public CartProductResponseDto update(Integer cartId, Integer productId, CartProductCreateDto dto) {
        CartProductId cartProductId = new CartProductId(cartId, productId);
        CartProduct cartProduct = cartProductRepository.findById(cartProductId)
                .orElseThrow(() -> new CartProductNotFoundException(cartId, productId));
        cartProduct.setCount(dto.getQuantity());
        CartProduct saved = cartProductRepository.save(cartProduct);
        return mapToResponseDto(saved);
    }

    public String delete(Integer cartId, Integer productId) {
        CartProductId cartProductId = new CartProductId(cartId, productId);
        return cartProductRepository.findById(cartProductId)
                .map(cartProduct -> {
                    cartProductRepository.delete(cartProduct);
                    return "Eliminado correctamente producto con ID: " + cartProduct.getProducto().getId() + " en el carro con ID: " + cartProduct.getCart().getCartId();
                })
                .orElseThrow(() -> new CartProductNotFoundException(cartId, productId));
    }

    private CartProductResponseDto mapToResponseDto(CartProduct cartProduct) {
        CartProductResponseDto cartProductResponseDto = new CartProductResponseDto();
        cartProductResponseDto.setProductId(cartProduct.getProducto().getId());
        cartProductResponseDto.setProductName(cartProduct.getProducto().getNombre());
        cartProductResponseDto.setPrice(cartProduct.getPrice());
        cartProductResponseDto.setQuantity(cartProduct.getCount());

        return cartProductResponseDto;
    }
}
