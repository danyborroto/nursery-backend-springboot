package com.code.spring.app.app.features.format.controller;

import com.code.spring.app.app.features.format.dto.FormatCreateDto;
import com.code.spring.app.app.features.format.dto.FormatResponseDto;
import com.code.spring.app.app.features.format.service.FormatService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formats")
public class FormatController {
    private final FormatService formatService;

    public FormatController(FormatService formatService){
        this.formatService = formatService;
    }

    @GetMapping
    public List<FormatResponseDto> getAll(){
        return formatService.getAll();
    }

    @GetMapping("/{id}")
    public FormatResponseDto getOne(@PathVariable Integer id){
        return formatService.getOne(id);
    }

    @PostMapping
    public FormatResponseDto create(@Valid @RequestBody FormatCreateDto format){
        return formatService.create(format);
    }

    @PutMapping("/{id}")
    public FormatResponseDto update(@PathVariable Integer id, @RequestBody FormatCreateDto format){
        return formatService.update(id, format);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return formatService.delete(id);
    }
}
