package com.edmarscenter.servidor.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name="venta")
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_venta;
	private Date fecha;
	private double precio_venta;
	
	@OneToMany(mappedBy="venta")
	private Set<Producto> productos;
	
	@ManyToOne
    @JoinColumn(name="id_empleado", nullable=false)
	private Empleado empleado;
	
	@ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuario;
	
	
	
}
