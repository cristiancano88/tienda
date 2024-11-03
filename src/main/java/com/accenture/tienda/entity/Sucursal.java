package com.accenture.tienda.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("sucursal")
public class Sucursal {

    @Id
    private Long id;
    private String nombre;
    private Long franquiciaId;
}
