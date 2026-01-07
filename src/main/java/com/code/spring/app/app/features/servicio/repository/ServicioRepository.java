package com.code.spring.app.app.features.servicio.repository;

import com.code.spring.app.app.features.servicio.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
}
