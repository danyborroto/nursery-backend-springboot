package com.code.spring.app.app.features.information.controller;

import com.code.spring.app.app.features.information.dto.InformationCreateDto;
import com.code.spring.app.app.features.information.dto.InformationResponseDto;
import com.code.spring.app.app.features.information.service.InformationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/information")
public class InformationController {
    private final InformationService informationService;

    public InformationController(InformationService informationService){
        this.informationService = informationService;
    }

    @GetMapping("/{id}")
    public InformationResponseDto getOne(@PathVariable Integer id){
        return informationService.getOne(id);
    }

    @PostMapping
    public InformationResponseDto create(@Valid @RequestBody InformationCreateDto dto){
        return informationService.create(dto);
    }

    @PutMapping("/{id}")
    public InformationResponseDto update(@PathVariable Integer id, @Valid @RequestBody InformationCreateDto dto){
        return informationService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return informationService.delete(id);
    }
}
