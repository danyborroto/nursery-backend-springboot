package com.code.spring.app.app.producto.repository;


import com.code.spring.app.app.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
