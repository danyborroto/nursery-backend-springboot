package com.code.spring.app.app.producto.service;

import com.code.spring.app.app.exception.ProductoNotFounException;
import com.code.spring.app.app.producto.dto.ProductoCreateDto;
import com.code.spring.app.app.producto.dto.ProductoResponseDto;
import com.code.spring.app.app.producto.model.Producto;
import com.code.spring.app.app.producto.repository.ProductoRepository;

import java.util.List;

public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoResponseDto> getAll() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(p -> new ProductoResponseDto(p.getNombre(),
                        p.getPrecio(),
                        p.getDescription(),
                        p.getCount(),
                        p.getHeight(),
                        p.getHeightUnit(),
                        p.getFormatId()))
                .toList();
    }

    public Producto getOne(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFounException(id));
    }

    public Producto create(ProductoCreateDto productoCreateDto) {
        Producto producto = new Producto();
        producto.setNombre(productoCreateDto.getNombre());
        producto.setPrecio(productoCreateDto.getPrecio());
        producto.setDescription(productoCreateDto.getDescription());
        producto.setCount(productoCreateDto.getCount());
        producto.setHeight(productoCreateDto.getHeight());
        producto.setHeightUnit(productoCreateDto.getHeightUnit());
        producto.setFormatId(productoCreateDto.getFormatId());
        return productoRepository.save(producto);
    }

    public Producto update(Integer id, Producto newProducto) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(newProducto.getNombre());
                    producto.setPrecio(newProducto.getPrecio());
                    producto.setDescription(newProducto.getDescription());
                    producto.setCount(newProducto.getCount());
                    producto.setHeight(newProducto.getHeight());
                    producto.setHeightUnit(newProducto.getHeightUnit());
                    producto.setFormatId(newProducto.getFormatId());
                    return productoRepository.save(producto);
                })
                .orElseThrow(() -> new ProductoNotFounException(id));
    }

    public String delete(Integer id) {
        return productoRepository.findById(id)
                .map(producto -> {
                    productoRepository.delete(producto);
                    return "Producto con id: " + id + " eliminado correctamente";
                })
                .orElseThrow(() -> new ProductoNotFounException(id));
    }
}
