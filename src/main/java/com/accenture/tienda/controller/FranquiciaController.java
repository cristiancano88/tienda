package com.accenture.tienda.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.tienda.entity.Franquicia;
import com.accenture.tienda.entity.Sucursal;
import com.accenture.tienda.service.FranquiciaService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    @PostMapping
    public Mono<Franquicia> agregarFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.agregarFranquicia(franquicia);
    }

    @PostMapping("/{franquiciaId}/sucursales")
    public Mono<Sucursal> agregarSucursal(@PathVariable Long franquiciaId, @RequestBody Sucursal sucursal) {
        return franquiciaService.agregarSucursal(franquiciaId, sucursal);
    }

    @PutMapping("/{franquiciaId}/nombre")
    public Mono<Franquicia> actualizarNombreFranquicia(@PathVariable Long franquiciaId, @RequestParam String nuevoNombre) {
        return franquiciaService.actualizarNombreFranquicia(franquiciaId, nuevoNombre);
    }

}
