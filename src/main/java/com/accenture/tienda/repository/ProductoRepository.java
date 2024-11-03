package com.accenture.tienda.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.accenture.tienda.entity.Producto;

@Repository
public interface ProductoRepository extends ReactiveCrudRepository<Producto, Long> {

}
