package com.edmarscenter.servidor.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="tipo")
public class Tipo implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_tipo;
	
	private String nombre;
	
	private boolean disponible;
	
	@OneToMany(mappedBy="tipo")
	private Set<Paquete> paquetes;

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Set<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(Set<Paquete> paquetes) {
		this.paquetes = paquetes;
	}
	
}
