package com.accenture.tienda.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("producto")
public class Producto {

    @Id
    private Long id;
    private String nombre;
    private Integer cantidadStock;
    private Long sucursalId;
}
