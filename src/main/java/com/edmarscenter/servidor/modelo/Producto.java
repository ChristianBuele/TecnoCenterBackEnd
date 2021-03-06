package com.edmarscenter.servidor.modelo;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
@Entity
@Table(name="producto")
public class Producto implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_producto;
	
	private String nombre;
	
	private double costo;
	
	private double precioSugeridoPublico;
	
	private double precioSugeridoMayorista;
	
	private String descripcion;
	
	private boolean disponibleVenta;
	
	private int cantidad;
	
	@JsonBackReference(value="pro-local")
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_local")
	private Local local;

	@JsonIgnore
	@OneToMany(mappedBy="producto")
	private Set<Venta> ventas;
	
	@JsonIgnore
	@OneToMany(mappedBy="producto")
	private Set<Imagen> imagenes;
	
//	@JsonBackReference(value="pro-cat")
	@ManyToOne
    @JoinColumn(name="id_categoria", nullable=false)
	private Categoria categoria;
	
	
	@ManyToOne()
    @JoinColumn(name="id_codigoDeBarra")
	private CodigoBarra codigoBarra;

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getPrecioSugeridoPublico() {
		return precioSugeridoPublico;
	}

	public void setPrecioSugeridoPublico(double precioSugeridoPublico) {
		this.precioSugeridoPublico = precioSugeridoPublico;
	}

	public double getPrecioSugeridoMayorista() {
		return precioSugeridoMayorista;
	}

	public void setPrecioSugeridoMayorista(double precioSugeridoMayorista) {
		this.precioSugeridoMayorista = precioSugeridoMayorista;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isDisponibleVenta() {
		return disponibleVenta;
	}

	public void setDisponibleVenta(boolean disponibleVenta) {
		this.disponibleVenta = disponibleVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Set<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}

	public Set<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(Set<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public CodigoBarra getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(CodigoBarra codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	
	
	
}
