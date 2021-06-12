package com.edmarscenter.servidor.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="reparacion")
public class Reparacion implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_reparacion;
	
	private String nombre;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fecha_ingreso;
	
	private String descripcion;
	
	@JsonFormat(pattern = "/dd/MM/yyyy")
	private Date fecha_salida;
	
	private double precio;
	
	private boolean reparado=false;
	
	private boolean entregado=false;
	
	
	@ManyToOne
    @JoinColumn(name="id_empleado", nullable=false)
	private Empleado empleado;
	
	@ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuario;

	public int getId_reparacion() {
		return id_reparacion;
	}

	public void setId_reparacion(int id_reparacion) {
		this.id_reparacion = id_reparacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isReparado() {
		return reparado;
	}

	public void setReparado(boolean reparado) {
		this.reparado = reparado;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
