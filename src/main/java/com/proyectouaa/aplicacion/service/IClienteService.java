package com.proyectouaa.aplicacion.service;

import java.util.List;

import com.proyectouaa.aplicacion.entity.Cliente;

public interface IClienteService {

	public List<Cliente> listarTodso();
	public void guardar(Cliente cliente);
	public Cliente buscarPorId(Long id);
	public void eliminar(Long id);

}
