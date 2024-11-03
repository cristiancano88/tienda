package com.accenture.tienda.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.tienda.entity.Sucursal;
import com.accenture.tienda.service.SucursalService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    @PutMapping("/{sucursalId}/nombre")
    public Mono<Sucursal> actualizarNombreSucursal(@PathVariable Long sucursalId, @RequestParam String nuevoNombre) {
        return sucursalService.actualizarNombreSucursal(sucursalId, nuevoNombre);
    }
}
