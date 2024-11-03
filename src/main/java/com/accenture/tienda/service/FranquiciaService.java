package com.accenture.tienda.service;

import org.springframework.stereotype.Service;

import com.accenture.tienda.entity.Franquicia;
import com.accenture.tienda.entity.Sucursal;
import com.accenture.tienda.repository.FranquiciaRepository;
import com.accenture.tienda.repository.SucursalRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    public Mono<Franquicia> agregarFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

}
