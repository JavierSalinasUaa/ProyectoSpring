package com.proyectouaa.aplicacion.repository;

import com.proyectouaa.aplicacion.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {


}

