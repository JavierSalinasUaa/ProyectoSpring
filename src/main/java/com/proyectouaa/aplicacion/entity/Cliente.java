package com.proyectouaa.aplicacion.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;


@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombres;
    @Column
    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellidos;
    @Column
    @NotBlank(message = "El nro de telefono no puede estar vacio")
    private String telefono;
    @Column
    @Email
    @NotBlank(message = "El email no puede estar vacio")
    private String email;


    @ManyToOne
    @JoinColumn(name = "ciudades_id")
    private Ciudad ciudad;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombres() {
        return nombres;
    }


    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    public String getApellidos() {
        return apellidos;
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Ciudad getCiudad() {
        return ciudad;
    }


    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }


    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono
                + ", email=" + email + ", ciudad=" + ciudad + "]";
    }
}