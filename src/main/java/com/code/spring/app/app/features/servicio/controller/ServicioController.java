package com.code.spring.app.app.features.servicio.controller;

import com.code.spring.app.app.features.servicio.dto.ServiceCreateDto;
import com.code.spring.app.app.features.servicio.dto.ServiceResponseDto;
import com.code.spring.app.app.features.servicio.service.ServicioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicioController {
    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService){
        this.servicioService = servicioService;
    }

    @GetMapping
    public List<ServiceResponseDto> getAll(){
        return servicioService.getAll();
    }

    @GetMapping("/{id}")
    public ServiceResponseDto getOne(@PathVariable Integer id){
        return servicioService.getOne(id);
    }

    @PostMapping
    public ServiceResponseDto create(@Valid @RequestBody ServiceCreateDto dto){
        return servicioService.create(dto);
    }

    @PutMapping("/{id}")
    public ServiceResponseDto update(@PathVariable Integer id, @Valid @RequestBody ServiceCreateDto dto){
        return servicioService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return servicioService.delete(id);
    }
}
