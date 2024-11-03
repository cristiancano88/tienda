package com.accenture.tienda.dto;

import com.accenture.tienda.entity.Producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoConSucursal {

    private String sucursalNombre;
    private Producto producto;

}
