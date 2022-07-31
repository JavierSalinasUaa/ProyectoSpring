package com.proyectouaa.aplicacion.controller;

import java.util.List;

import com.proyectouaa.aplicacion.entity.Cliente;
import com.proyectouaa.aplicacion.entity.Cobro;
import com.proyectouaa.aplicacion.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.proyectouaa.aplicacion.service.ICobroService;


@Controller
@RequestMapping("/views/cobros/")
public class CobroController {

    @Autowired
    private ICobroService cobroService;

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/")
    public String listarCobros(Model model) {
        List<Cobro> listadoCobros = cobroService.listarTodos();

        model.addAttribute("titulo", "Lista de Cobros");
        model.addAttribute("cobros", listadoCobros);

        return "views/cobros/listar";
    }
    @GetMapping("/create")
    public String crear(Model model) {
        Cobro cobro = new Cobro();
        List<Cliente> listClientes = clienteService.listarTodso();

        model.addAttribute("titulo", "Formulario: Nuevo Cobro");
        model.addAttribute("cobro", cobro);
        model.addAttribute("clientes", listClientes);

        return "views/cobros/frmCrear";

    }

    @PostMapping("/save")
    public String guardar(@Validated @ModelAttribute Cobro cobro, BindingResult result, Model model){
        List<Cliente> listClientes = clienteService.listarTodso();

        if (result.hasErrors()){
            model.addAttribute("titulo", "Formulario: Nuevo Cobro");
            model.addAttribute("cobro", cobro);
            model.addAttribute("clientes", listClientes);
            System.out.println("Hay errores en el formulario");
            return "views/cobros/frmCrear";
        }

        cobroService.guardar(cobro);
        System.out.println("Cobro Guardado con exito");
        return "redirect:/views/cobros/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idCobro, Model model) {
        Cobro cobro = cobroService.buscarPorId(idCobro);

        List<Cliente> listClientes = clienteService.listarTodso();

        model.addAttribute("titulo", "Formulario: Editar Cobro");
        model.addAttribute("cobro", cobro);
        model.addAttribute("clientes", listClientes);

        return "views/cobros/frmCrear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idCobro) {
        cobroService.eliminar(idCobro);
        System.out.println("Registro eliminado con exito!");

        return "redirect:/views/cobros/";
    }
}

