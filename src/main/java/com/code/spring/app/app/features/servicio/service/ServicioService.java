package com.code.spring.app.app.features.servicio.service;

import com.code.spring.app.app.exception.ServiceNotFoundException;
import com.code.spring.app.app.features.servicio.dto.ServiceCreateDto;
import com.code.spring.app.app.features.servicio.dto.ServiceResponseDto;
import com.code.spring.app.app.features.servicio.entity.Servicio;
import com.code.spring.app.app.features.servicio.repository.ServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {
    private final ServicioRepository serviceRepository;

    public ServicioService(ServicioRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceResponseDto> getAll() {
        return serviceRepository.findAll().stream()
                .map(s -> new ServiceResponseDto(
                        s.getServiceName(),
                        s.getSelecteable()
                ))
                .toList();
    }

    public ServiceResponseDto getOne(Integer id) {
        Servicio service = serviceRepository.findById(id)
                .orElseThrow(() -> new ServiceNotFoundException(id));
        return mapToServiceResponseDto(service);
    }

    public ServiceResponseDto create(ServiceCreateDto dto) {
        Servicio s = new Servicio();
        s.setServiceName(dto.getServiceName());
        s.setSelecteable(dto.getSelecteable());
        Servicio saved = serviceRepository.save(s);
        return mapToServiceResponseDto(saved);
    }

    public ServiceResponseDto update(Integer id, ServiceCreateDto dto){
        Servicio s = serviceRepository.findById(id)
                .orElseThrow(()->new ServiceNotFoundException(id));
        s.setServiceName(dto.getServiceName());
        s.setSelecteable(dto.getSelecteable());
        return mapToServiceResponseDto(serviceRepository.save(s));
    }

    public String delete(Integer id){
        return serviceRepository.findById(id)
                .map(s->{
                    serviceRepository.delete(s);
                    return "Servicio con id: "+id+" eliminado correctamente";
                })
                .orElseThrow(()->new ServiceNotFoundException(id));

    }

    private ServiceResponseDto mapToServiceResponseDto(Servicio service) {
        return new ServiceResponseDto(
                service.getServiceName(),
                service.getSelecteable()
        );
    }
}
