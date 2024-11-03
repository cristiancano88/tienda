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
    private final SucursalRepository sucursalRepository;

    public Mono<Franquicia> agregarFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public Mono<Sucursal> agregarSucursal(Long franquiciaId, Sucursal sucursal) {
        return franquiciaRepository.findById(franquiciaId)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Franquicia no encontrada")))
                .flatMap(franquicia -> {
                    sucursal.setFranquiciaId(franquiciaId);
                    return sucursalRepository.save(sucursal);
                });
    }

}
