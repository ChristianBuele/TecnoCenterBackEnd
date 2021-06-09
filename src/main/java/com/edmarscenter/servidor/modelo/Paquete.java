package com.edmarscenter.servidor.modelo;

import javax.persistence.*;

@Entity
@Table(name="paquete")
public class Paquete {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_paquete;
	
	private String descripcion;
	
	private double valor_mensual;
	
	@ManyToOne
    @JoinColumn(name="id_tipo", nullable=false)
	private Tipo tipo;

	public int getId_paquete() {
		return id_paquete;
	}

	public void setId_paquete(int id_paquete) {
		this.id_paquete = id_paquete;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValor_mensual() {
		return valor_mensual;
	}

	public void setValor_mensual(double valor_mensual) {
		this.valor_mensual = valor_mensual;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
}
