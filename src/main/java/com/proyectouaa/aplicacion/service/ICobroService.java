package com.proyectouaa.aplicacion.service;
import java.util.List;

import com.proyectouaa.aplicacion.entity.Cobro;


public interface ICobroService {

    public List<Cobro> listarTodos();
    public void guardar(Cobro cobro);
    public Cobro buscarPorId(Long id);
    public void eliminar(Long id);

}
