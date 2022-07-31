package com.proyectouaa.aplicacion.controller;

import java.util.List;

import com.proyectouaa.aplicacion.entity.Ciudad;
import com.proyectouaa.aplicacion.entity.Cliente;
import com.proyectouaa.aplicacion.entity.Cobro;
import com.proyectouaa.aplicacion.entity.DetalleCobro;
import com.proyectouaa.aplicacion.service.ICiudadService;
import com.proyectouaa.aplicacion.service.IDetalleCobroService;
import com.proyectouaa.aplicacion.service.ICobroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/views/detalleCobros/")
public class DetalleCobroController {

    @Autowired
    private IDetalleCobroService detalleCobroService;

    @Autowired
    private ICobroService cobroService;

    @Autowired
    private ICiudadService ciudadService;

    @GetMapping("/")
    public String listarDetalleCobros(Model model) {
        List<DetalleCobro> listadoDetalle = detalleCobroService.listarTodos();

        model.addAttribute("titulo", "Detalle de Cobros");
        model.addAttribute("detalle_cobros", listadoDetalle);

        return "views/detalleCobros/listar";
    }
    @GetMapping("/create")
    public String crear(Model model) {
        DetalleCobro detalle_cobro = new DetalleCobro();
        List<Cobro> listCobros = cobroService.listarTodos();
        List<Ciudad> listCiudades = ciudadService.listaCiudades();

        model.addAttribute("titulo", "Formulario: Detalle Cobro");
        model.addAttribute("detalle_cobro", detalle_cobro);
        model.addAttribute("cobros", listCobros);
        model.addAttribute("ciudades", listCiudades);

        return "views/detalleCobros/frmCrear";

    }

    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute DetalleCobro detalleCobro, BindingResult result, Model model){
        List<Cobro> listCobros = cobroService.listarTodos();
        List<Ciudad> listCiudades = ciudadService.listaCiudades();

        if (result.hasErrors()){
            model.addAttribute("titulo", "Formulario: Detalle de Cobro");
            model.addAttribute("detalle_cobro", detalleCobro);
            model.addAttribute("ciudades", listCiudades);
            model.addAttribute("cobros", listCobros);
            System.out.println("Hay errores en el formulario");
            return "views/detalleCobros/frmCrear";
        }

        detalleCobroService.guardar(detalleCobro);
        System.out.println("Detalle Guardado con exito");
        return "redirect:/detalleCobros/clientes/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idDetalleCobro, Model model) {
        DetalleCobro detalle_cobro = detalleCobroService.buscarPorId(idDetalleCobro);

        List<Cobro> listCobros = cobroService.listarTodos();
        List<Ciudad> listCiudades = ciudadService.listaCiudades();

        model.addAttribute("titulo", "Formulario: Editar Detalle Cobro");
        model.addAttribute("detalle_cobro", detalle_cobro);
        model.addAttribute("cobros", listCobros);
        model.addAttribute("ciudades", listCiudades);

        return "views/detalleCobros/frmCrear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idDetalleCobro) {
        detalleCobroService.eliminar(idDetalleCobro);
        System.out.println("Registro eliminado con exito!");

        return "redirect:/views/detalleCobros/";
    }
}

