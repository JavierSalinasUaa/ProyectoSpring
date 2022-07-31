package com.proyectouaa.aplicacion.controller;

import java.util.List;

import com.proyectouaa.aplicacion.entity.Ciudad;
import com.proyectouaa.aplicacion.service.ICiudadService;
import com.proyectouaa.aplicacion.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.proyectouaa.aplicacion.service.IClienteService;

import javax.validation.Valid;

@Controller
@RequestMapping("/views/clientes/")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private ICiudadService ciudadService;

    @GetMapping("/")
    public String listarClientes(Model model) {
        List<Cliente> listadoClientes = clienteService.listarTodso();

        model.addAttribute("titulo", "Lista de Clientes");
        model.addAttribute("clientes", listadoClientes);

        return "views/clientes/listar";
    }
    @GetMapping("/create")
    public String crear(Model model) {
        Cliente cliente = new Cliente();
        List<Ciudad> listCiudades = ciudadService.listaCiudades();

        model.addAttribute("titulo", "Formulario:Nuevo Cliente");
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", listCiudades);

        return "views/clientes/frmCrear";
    }

    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model){
        List<Ciudad> listCiudades = ciudadService.listaCiudades();

        if (result.hasErrors()){
            model.addAttribute("titulo", "Formulario:Nuevo Cliente");
            model.addAttribute("cliente", cliente);
            model.addAttribute("ciudades", listCiudades);
            System.out.println("Hay errores en el formulario");
            return "views/clientes/frmCrear";
        }

        clienteService.guardar(cliente);
        System.out.println("Cliente Guardado con exito");
        return "redirect:/views/clientes/";
    }
    //AÑADIDO DE JAVI
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idCliente, Model model) {
        Cliente cliente = clienteService.buscarPorId(idCliente);

        List<Ciudad> listCiudades = ciudadService.listaCiudades();

        model.addAttribute("titulo", "Formulario: Editar Cliente");
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", listCiudades);

        return "views/clientes/frmCrear";
    }
    //AÑADIDO DE JAVI
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idCliente) {
        clienteService.eliminar(idCliente);
        System.out.println("Registro eliminado con exito!");

        return "redirect:/views/clientes/";
    }
}

