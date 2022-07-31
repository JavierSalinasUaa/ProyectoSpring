package com.proyectouaa.aplicacion.service;

import com.proyectouaa.aplicacion.entity.DetalleCobro;

import java.util.List;


public interface IDetalleCobroService {

    public List<DetalleCobro> listarTodos();
    public void guardar(DetalleCobro detalle_cobrocobro);
    public DetalleCobro buscarPorId(Long id);
    public void eliminar(Long id);

}
