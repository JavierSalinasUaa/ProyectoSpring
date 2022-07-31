package com.proyectouaa.aplicacion.service;

import java.util.List;

import com.proyectouaa.aplicacion.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectouaa.aplicacion.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodso() {

        return (List<Cliente>)clienteRepository.findAll();
    }

    @Override
    public void guardar(Cliente cobro) {
        clienteRepository.save(cobro);

    }

    @Override
    public Cliente buscarPorId(Long id) {

        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);

    }

}