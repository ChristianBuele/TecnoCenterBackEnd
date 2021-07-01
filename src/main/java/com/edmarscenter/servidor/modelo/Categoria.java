package com.edmarscenter.servidor.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_categoria;
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy="categoria")
	private Set<Producto> productos;
	
	

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	

}
