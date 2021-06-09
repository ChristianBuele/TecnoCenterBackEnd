package com.edmarscenter.servidor.modelo;


import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_usuario;
	
	private String nombre;
	private String correo;
	private String telefono;
	private String direccion;
	
	@OneToMany(mappedBy="usuario")
	private Set<Reparacion> reparaciones;
	
	@OneToMany(mappedBy="usuario")
	private Set<Venta> ventas;
	
	@OneToMany(mappedBy="usuario")
	private Set<Contrato> contratos;

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<Reparacion> getReparaciones() {
		return reparaciones;
	}

	public void setReparaciones(Set<Reparacion> reparaciones) {
		this.reparaciones = reparaciones;
	}

	public Set<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}

	public Set<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(Set<Contrato> contratos) {
		this.contratos = contratos;
	}

	
	
}
