package com.proyectouaa.aplicacion.service;

import com.proyectouaa.aplicacion.entity.Cobro;
import com.proyectouaa.aplicacion.repository.CobroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CobroServiceImpl implements ICobroService {

    @Autowired
    private CobroRepository cobroRepository;

    @Override
    public List<Cobro> listarTodos() {

        return (List<Cobro>)cobroRepository.findAll();
    }

    @Override
    public void guardar(Cobro cobro) {
        cobroRepository.save(cobro);

    }

    @Override
    public Cobro buscarPorId(Long id) {

        return cobroRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        cobroRepository.deleteById(id);

    }
}
