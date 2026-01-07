package com.code.spring.app.app.features.producto.controller;

import com.code.spring.app.app.features.producto.dto.ProductoCreateDto;
import com.code.spring.app.app.features.producto.dto.ProductoResponseDto;
import com.code.spring.app.app.features.producto.entity.Producto;
import com.code.spring.app.app.features.producto.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoResponseDto> getAll() {
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public ProductoResponseDto getOne(@PathVariable Integer id) {
        return productoService.getOne(id);
    }

    @PostMapping
    public ProductoResponseDto create(@Valid @RequestBody ProductoCreateDto productoCreateDto) {
        return productoService.create(productoCreateDto);
    }

    @PutMapping("/{id}")
    public ProductoResponseDto update(@PathVariable Integer id, @RequestBody ProductoCreateDto newProducto) {
        return productoService.update(id, newProducto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return productoService.delete(id);
    }
}
