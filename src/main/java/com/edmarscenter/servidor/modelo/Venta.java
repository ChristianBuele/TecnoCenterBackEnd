package com.edmarscenter.servidor.modelo;

import javax.persistence.*;
@Entity
@Table(name="venta")
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_venta;
	private boolean mayorista=false;
	private double precio_venta;
	
	@ManyToOne
    @JoinColumn(name="id_producto", nullable=false)
	private Producto producto;
	
	@ManyToOne
    @JoinColumn(name="id_empleado", nullable=false)
	private Empleado empleado;
	
	@ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuario;

	
	@ManyToOne
    @JoinColumn(name="id_factura", nullable=false)
	private Factura factura;


	public int getId_venta() {
		return id_venta;
	}


	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}


	public boolean isMayorista() {
		return mayorista;
	}


	public void setMayorista(boolean mayorista) {
		this.mayorista = mayorista;
	}


	public double getPrecio_venta() {
		return precio_venta;
	}


	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
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


	public Factura getFactura() {
		return factura;
	}


	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
	
	
}
