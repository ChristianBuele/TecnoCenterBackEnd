package com.edmarscenter.servidor.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="gerente")
public class Gerente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_gerente;
	private String nombre;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_local", referencedColumnName = "id_local")
	private Local local;

	public int getId_gerente() {
		return id_gerente;
	}

	public void setId_gerente(int id_gerente) {
		this.id_gerente = id_gerente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	
}
