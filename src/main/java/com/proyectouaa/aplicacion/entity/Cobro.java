package com.proyectouaa.aplicacion.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

@Entity
@Table(name="cobros")
public class Cobro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank(message = "El servicio no puede estar vacio")
    private String servicio;

    @Column
    @Digits(integer=6, fraction=4)
    @Min(value = 1, message = "Ingrese un valor mayor a 1")
    @Max(value = 100000000, message = "Ingrese un valor menor a 9999999")
    @NotNull(message = "Ingrese el monto del servicio")
    private Double costo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    public Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Cobro{" +
                "id=" + id +
                ", servicio='" + servicio + '\'' +
                ", costo=" + costo +
                ", cliente=" + cliente +
                '}';
    }
}
