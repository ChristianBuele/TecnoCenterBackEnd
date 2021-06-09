package com.edmarscenter.servidor.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="imagen")
public class Imagen implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_imagen;
	
	@ManyToOne
    @JoinColumn(name="id_producto", nullable=false)
	private Producto producto;
	
	private String link;

	public int getId_imagen() {
		return id_imagen;
	}

	public void setId_imagen(int id_imagen) {
		this.id_imagen = id_imagen;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
