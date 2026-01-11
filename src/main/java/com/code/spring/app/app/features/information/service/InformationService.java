package com.code.spring.app.app.features.information.service;

import com.code.spring.app.app.exception.InformationNotFoundException;
import com.code.spring.app.app.features.information.dto.InformationCreateDto;
import com.code.spring.app.app.features.information.dto.InformationResponseDto;
import com.code.spring.app.app.features.information.entity.Information;
import com.code.spring.app.app.features.information.repository.InformationRepository;
import org.springframework.stereotype.Service;

@Service
public class InformationService {
    private final InformationRepository informationRepository;

    public InformationService(InformationRepository informationRepository){
        this.informationRepository = informationRepository;
    }

    public InformationResponseDto getOne(Integer id){
        Information info = informationRepository.findById(id)
                .orElseThrow(
                        ()->new InformationNotFoundException(id));
        return mapToInfoResponseDTo(info);
    }

    public InformationResponseDto create(InformationCreateDto dto){
        Information info = new Information();
        info.setNurseryName(dto.getNurseryName());
        info.setDescription(dto.getDescription());
        info.setHistory(dto.getHistory());
        info.setAddress(dto.getAddress());
        info.setPrimaryPhone(dto.getPrimaryPhone());
        info.setSecondaryPhone(dto.getSecondaryPhone());
        info.setEmail(dto.getEmail());
        Information saved = informationRepository.save(info);
        return mapToInfoResponseDTo(saved);
    }

    public InformationResponseDto update(Integer id, InformationCreateDto dto){
        Information info = informationRepository.findById(id)
                .orElseThrow(()->new InformationNotFoundException(id));
        info.setNurseryName(dto.getNurseryName());
        info.setDescription(dto.getDescription());
        info.setHistory(dto.getHistory());
        info.setAddress(dto.getAddress());
        info.setPrimaryPhone(dto.getPrimaryPhone());
        info.setSecondaryPhone(dto.getSecondaryPhone());
        info.setEmail(dto.getEmail());
        return mapToInfoResponseDTo(informationRepository.save(info));
    }

    public String delete(Integer id){
        return informationRepository.findById(id)
                .map(i->{
                    informationRepository.delete(i);
                    return "Información con ID: "+id+" eliminada correctamente";
                })
                .orElseThrow(()->new InformationNotFoundException(id));
    }

    private InformationResponseDto mapToInfoResponseDTo(Information info){
        return new InformationResponseDto(
                info.getNurseryName(),
                info.getDescription(),
                info.getHistory(),
                info.getAddress(),
                info.getPrimaryPhone(),
                info.getSecondaryPhone(),
                info.getEmail()
        );
    }
}

