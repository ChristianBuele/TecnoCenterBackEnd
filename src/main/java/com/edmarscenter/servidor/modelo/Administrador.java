package com.edmarscenter.servidor.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="administrador")
public class Administrador implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_administrador;
	private String nombre;
	private String correo;
	private String contra;
	
	@JsonBackReference(value="admin-local")
	@OneToMany(mappedBy="administrador")
	private Set<Local> locales;

	public int getId_administrador() {
		return id_administrador;
	}

	public void setId_administrador(int id_administrador) {
		this.id_administrador = id_administrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Local> getLocales() {
		return locales;
	}

	public void setLocales(Set<Local> locales) {
		this.locales = locales;
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
	
	
}
