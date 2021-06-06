package com.edmarscenter.servidor.modelo;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_producto;
	
	private String nombre;
	private double costo;
	private double precioSugerido;
	private String descripcion;
	private boolean disponibleVenta;
	private int cantidad;
	

	
	@ManyToOne
    @JoinColumn(name="id_local", nullable=false)
	private Local local;
	
	@ManyToOne
    @JoinColumn(name="id_venta", nullable=false)
	private Venta venta;
	
	@OneToMany(mappedBy="producto")
	private Set<Imagen> imagenes;
	
//	@ManyToMany
//	@JoinTable(name="usuarioproducto",joinColumns =@JoinColumn(name="id_producto"),inverseJoinColumns = @JoinColumn(name="id_usuario") )
//	private List<Usuario> usuarios;
	
}
