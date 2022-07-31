package com.proyectouaa.aplicacion.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="detalle_cobros")
public class DetalleCobro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank(message = "El servicio no puede estar vacio")
    private String f_pago;
    @Column
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "cobros")
    private Cobro cobro;

    @ManyToOne
    @JoinColumn(name = "ciudades")
    private Ciudad ciudad;

    public Long getId() {
        return id;
    }

    public String getF_pago() {
        return f_pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cobro getCobro() {
        return cobro;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setF_pago(String f_pago) {
        this.f_pago = f_pago;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCobro(Cobro cobro) {
        this.cobro = cobro;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "DetalleCobro{" +
                "id=" + id +
                ", f_pago='" + f_pago + '\'' +
                ", fecha=" + fecha +
                ", cobro=" + cobro +
                ", ciudad=" + ciudad +
                '}';
    }
}
