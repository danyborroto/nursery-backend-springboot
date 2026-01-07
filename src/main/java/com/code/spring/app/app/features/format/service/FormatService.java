package com.code.spring.app.app.features.format.service;

import com.code.spring.app.app.features.format.dto.FormatCreateDto;
import com.code.spring.app.app.features.format.dto.FormatResponseDto;
import com.code.spring.app.app.features.format.entity.Format;
import com.code.spring.app.app.features.format.repository.FormatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormatService {
    private final FormatRepository formatRepository;

    public FormatService(FormatRepository formatRepository) {
        this.formatRepository = formatRepository;
    }

    public List<FormatResponseDto> getAll() {
        return formatRepository.findAll().stream()
                .map(f -> new FormatResponseDto(
                        f.getFormatId(),
                        f.getFormatName()
                ))
                .toList();
    }

    public FormatResponseDto getOne(Integer id) {
        Format format = formatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formato no encontrado con ID: " + id));
        return mapToFormatResponseDto(format);
    }

    public FormatResponseDto create(FormatCreateDto dto) {
        Format format = new Format();
        format.setFormatName(dto.getName());
        Format saved = formatRepository.save(format);
        return mapToFormatResponseDto(saved);
    }

    public FormatResponseDto update(Integer id, FormatCreateDto dto) {
        Format format = formatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formato no encontrado con ID: " + id));
        format.setFormatName(dto.getName());
        return mapToFormatResponseDto(formatRepository.save(format));
    }

    public String delete(Integer id) {
        return formatRepository.findById(id)
                .map(f -> {
                    formatRepository.delete(f);
                    return "Formato con id: " + id + " eliminado correctamente";
                })
                .orElseThrow(() -> new RuntimeException("Formato no encontrado con ID: " + id));
    }

    private FormatResponseDto mapToFormatResponseDto(Format f) {
        FormatResponseDto formatResponseDto = new FormatResponseDto(f.getFormatId(), f.getFormatName());
        return formatResponseDto;
    }
}
