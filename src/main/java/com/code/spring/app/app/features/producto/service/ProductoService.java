package com.code.spring.app.app.features.producto.service;

import com.code.spring.app.app.exception.ProductoNotFounException;
import com.code.spring.app.app.features.format.dto.FormatResponseDto;
import com.code.spring.app.app.features.format.entity.Format;
import com.code.spring.app.app.features.format.repository.FormatRepository;
import com.code.spring.app.app.features.producto.dto.ProductoCreateDto;
import com.code.spring.app.app.features.producto.dto.ProductoResponseDto;
import com.code.spring.app.app.features.producto.entity.Producto;
import com.code.spring.app.app.features.producto.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final FormatRepository formatRepository;

    public ProductoService(ProductoRepository productoRepository, FormatRepository formatRepository) {
        this.productoRepository = productoRepository;
        this.formatRepository = formatRepository;
    }

    public List<ProductoResponseDto> getAll() {
        return productoRepository.findAll().stream()
                .map(p -> new ProductoResponseDto(p.getNombre(),
                        p.getPrecio(),
                        p.getDescription(),
                        p.getCount(),
                        p.getHeight(),
                        p.getHeightUnit(),
                        new FormatResponseDto(
                                p.getFormat().getFormatId(),
                                p.getFormat().getFormatName()
                        )
                ))
                .toList();
    }

    public ProductoResponseDto getOne(Integer id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFounException(id));
        return mapToResponseDto(producto);
    }

    public ProductoResponseDto create(ProductoCreateDto productoCreateDto) {
        Format format = formatRepository.findById(productoCreateDto.getFormatId())
                .orElseThrow(() ->
                        new RuntimeException("Formato no encontrado con el ID: " + productoCreateDto.getFormatId()));
        Producto producto = new Producto();
        producto.setNombre(productoCreateDto.getNombre());
        producto.setPrecio(productoCreateDto.getPrecio());
        producto.setDescription(productoCreateDto.getDescription());
        producto.setCount(productoCreateDto.getCount());
        producto.setHeight(productoCreateDto.getHeight());
        producto.setHeightUnit(productoCreateDto.getHeightUnit());
        producto.setFormat(format);
        Producto saved = productoRepository.save(producto);
        return mapToResponseDto(saved);
    }

    public ProductoResponseDto update(Integer id, ProductoCreateDto dto) {
        Format format = formatRepository.findById(dto.getFormatId())
                .orElseThrow(() ->
                        new RuntimeException("Formato no encontrado con el ID: " + dto.getFormatId()));
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->
                        new ProductoNotFounException(id));
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setDescription(dto.getDescription());
        producto.setCount(dto.getCount());
        producto.setHeight(dto.getHeight());
        producto.setHeightUnit(dto.getHeightUnit());
        producto.setFormat(format);
        return mapToResponseDto(productoRepository.save(producto));
    }

    public String delete(Integer id) {
        return productoRepository.findById(id)
                .map(producto -> {
                    productoRepository.delete(producto);
                    return "Producto con id: " + id + " eliminado correctamente";
                })
                .orElseThrow(() -> new ProductoNotFounException(id));
    }

    private ProductoResponseDto mapToResponseDto(Producto producto) {
        return new ProductoResponseDto(
                producto.getNombre(),
                producto.getPrecio(),
                producto.getDescription(),
                producto.getCount(),
                producto.getHeight(),
                producto.getHeightUnit(),
                new FormatResponseDto(
                        producto.getFormat().getFormatId(),
                        producto.getFormat().getFormatName()
                )
        );
    }
}
