package com.code.spring.app.app.producto.controller;

import com.code.spring.app.app.exception.ProductoNotFounException;
import com.code.spring.app.app.producto.dto.ProductoCreateDto;
import com.code.spring.app.app.producto.dto.ProductoResponseDto;
import com.code.spring.app.app.producto.model.Producto;
import com.code.spring.app.app.producto.repository.ProductoRepository;
import com.code.spring.app.app.producto.service.ProductoService;
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
    public Producto getOne(@PathVariable Integer id) {
        return productoService.getOne(id);
    }

    @PostMapping
    public Producto create(@Valid @RequestBody ProductoCreateDto productoCreateDto) {
        return productoService.create(productoCreateDto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Integer id, @RequestBody Producto newProducto) {
        return productoService.update(id, newProducto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return productoService.delete(id);
    }
}
