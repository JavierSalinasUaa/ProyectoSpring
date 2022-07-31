package com.proyectouaa.aplicacion.service;

import com.proyectouaa.aplicacion.entity.Ciudad;
import com.proyectouaa.aplicacion.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CiudadServiceImpl implements ICiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public List<Ciudad> listaCiudades(){


        return (List<Ciudad>) ciudadRepository.findAll();
    }
}
