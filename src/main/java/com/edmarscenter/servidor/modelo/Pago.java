package com.edmarscenter.servidor.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pago")
public class Pago {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_pago;
	
	private Date fecha_pago;
	
	private double valor;
	
	@ManyToOne
    @JoinColumn(name="id_factura", nullable=false)
	private Factura factura;
	
	@ManyToOne
    @JoinColumn(name="id_contrato", nullable=false)
	private Contrato contrato;

	public int getId_pago() {
		return id_pago;
	}

	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}

	public Date getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	
	
}
