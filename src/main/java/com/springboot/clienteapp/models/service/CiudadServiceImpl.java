package com.springboot.clienteapp.models.service;

import com.springboot.clienteapp.models.entity.Ciudad;
import com.springboot.clienteapp.models.repository.CiudadRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CiudadServiceImpl implements ICiudadService {

    @Autowired
    private CiudadRespository ciudadRespository;

    @Override
    public List<Ciudad> listaCiudades(){


        return (List<Ciudad>) ciudadRespository.findAll();
    }
}
