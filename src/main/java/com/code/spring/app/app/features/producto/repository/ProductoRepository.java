package com.code.spring.app.app.features.producto.repository;


import com.code.spring.app.app.features.producto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
