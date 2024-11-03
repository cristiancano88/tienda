package com.accenture.tienda.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.accenture.tienda.entity.Franquicia;

@Repository
public interface FranquiciaRepository extends ReactiveCrudRepository<Franquicia, Long> {

}
