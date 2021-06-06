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
}
