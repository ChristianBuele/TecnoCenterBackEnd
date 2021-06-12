package com.edmarscenter.servidor.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="local")
public class Local implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_local;
	private String nombre;
	private String telefono;
	
	@JsonBackReference(value="lo-pro")
	@OneToMany(mappedBy = "local",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Producto> productos;
	
	@JsonIgnore
	@OneToMany(mappedBy="local")
	private Set<Redes> redes;
	
	@JsonIgnore
	@OneToMany(mappedBy="local")
	private Set<Empleado> empleados;
	

	
	@JsonBackReference(value="local-admin")
	@ManyToOne
    @JoinColumn(name="id_administrador", nullable=false)
	private Administrador administrador;
	


	public int getId_local() {
		return id_local;
	}

	public void setId_local(int id_local) {
		this.id_local = id_local;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public Set<Redes> getRedes() {
		return redes;
	}

	public void setRedes(Set<Redes> redes) {
		this.redes = redes;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	
}
