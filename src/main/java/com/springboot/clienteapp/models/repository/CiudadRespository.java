package com.springboot.clienteapp.models.repository;

import com.springboot.clienteapp.models.entity.Ciudad;
import org.springframework.data.repository.CrudRepository;

public interface CiudadRespository extends CrudRepository<Ciudad, Long> {
}
