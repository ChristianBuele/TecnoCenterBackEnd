package com.edmarscenter.servidor.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CompraExtra")
public class CompraExtra implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_compraextra;
	
	private Date fecha_compra;
	private String descripcion;
	private double valor;
	
//	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="id_empleado", nullable=false)
	private Empleado empleado;

	public int getId_compraExtra() {
		return id_compraextra;
	}

	public void setId_compraExtra(int id_compraExtra) {
		this.id_compraextra = id_compraExtra;
	}

	public Date getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	
}
