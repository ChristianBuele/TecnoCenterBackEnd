package com.edmarscenter.servidor.modelo;

import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name="local")
public class Local {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_local;
	private String nombre;
	private String telefono;
	
	@OneToMany(mappedBy="local")
	private Set<Producto> productos;
	
	@OneToMany(mappedBy="local")
	private Set<Redes> redes;
	
	@OneToMany(mappedBy="local")
	private Set<Empleado> empleados;
	
	@OneToOne(mappedBy = "local")
	private Gerente gerente;
	
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

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	
}
