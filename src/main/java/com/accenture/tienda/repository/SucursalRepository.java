package com.accenture.tienda.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.accenture.tienda.entity.Sucursal;

@Repository
public interface SucursalRepository extends ReactiveCrudRepository<Sucursal, Long> {

}
