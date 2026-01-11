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
        Information saved = informationRepository.save(mapDtoToInformation(info,dto));
        return mapToInfoResponseDTo(saved);
    }

    public InformationResponseDto update(Integer id, InformationCreateDto dto){
        Information info = informationRepository.findById(id)
                .orElseThrow(()->new InformationNotFoundException(id));

        return mapToInfoResponseDTo(informationRepository.save(mapDtoToInformation(info,dto)));
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

    private Information mapDtoToInformation(Information info, InformationCreateDto dto){
        Information information = info;
        information.setNurseryName(dto.getNurseryName());
        information.setDescription(dto.getDescription());
        information.setHistory(dto.getHistory());
        information.setAddress(dto.getAddress());
        information.setPrimaryPhone(dto.getPrimaryPhone());
        information.setSecondaryPhone(dto.getSecondaryPhone());
        information.setEmail(dto.getEmail());
        return information;
    }
}

