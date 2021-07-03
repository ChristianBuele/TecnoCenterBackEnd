package com.edmarscenter.servidor.modelo;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_empleado;
	
	private String nombre;
	private String apellido;
	private String numero;
	private String correo;
	private String contra;
	private boolean activo=true;
	private boolean rol=false;
	
	@JsonIgnore
	@OneToMany(mappedBy="empleado")
	private Set<Venta> ventas;
	
	@ManyToOne
    @JoinColumn(name="id_local", nullable=false)
	private Local local;
	
	@JsonIgnore
	@OneToMany(mappedBy="empleado")
	private Set<Reparacion> reparaciones;
	
	@JsonIgnore
	@OneToMany(mappedBy="empleado")
	private Set<CompraExtra> comprasExtra;

	@JsonIgnore
	@OneToMany(mappedBy="empleado")
	private Set<Contrato> contratos;

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean isRol() {
		return rol;
	}

	public void setRol(boolean rol) {
		this.rol = rol;
	}

	public Set<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Set<Reparacion> getReparaciones() {
		return reparaciones;
	}

	public void setReparaciones(Set<Reparacion> reparaciones) {
		this.reparaciones = reparaciones;
	}

	public Set<CompraExtra> getComprasExtra() {
		return comprasExtra;
	}

	public void setComprasExtra(Set<CompraExtra> comprasExtra) {
		this.comprasExtra = comprasExtra;
	}

	public Set<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(Set<Contrato> contratos) {
		this.contratos = contratos;
	}


	


	
}
