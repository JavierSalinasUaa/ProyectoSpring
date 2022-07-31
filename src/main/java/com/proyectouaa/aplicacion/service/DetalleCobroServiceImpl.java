package com.proyectouaa.aplicacion.service;

import com.proyectouaa.aplicacion.entity.DetalleCobro;
import com.proyectouaa.aplicacion.repository.DetalleCobroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCobroServiceImpl implements IDetalleCobroService {

    @Autowired
    private DetalleCobroRepository detalleCobroRepository;

    @Override
    public List<DetalleCobro> listarTodos() {

        return (List<DetalleCobro>)detalleCobroRepository.findAll();
    }

    @Override
    public void guardar(DetalleCobro detalle_cobro) {
        detalleCobroRepository.save(detalle_cobro);

    }

    @Override
    public DetalleCobro buscarPorId(Long id) {

        return detalleCobroRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        detalleCobroRepository.deleteById(id);

    }
}
