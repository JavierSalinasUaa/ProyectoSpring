package com.proyectouaa.aplicacion.repository;

import com.proyectouaa.aplicacion.entity.Cobro;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface CobroRepository extends CrudRepository<Cobro, Long> {

}
