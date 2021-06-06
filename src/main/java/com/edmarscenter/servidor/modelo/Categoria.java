package com.edmarscenter.servidor.modelo;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_categoria;
	private String nombre;
	
	@OneToMany(mappedBy="categoria")
	private Set<Producto> productos;

}
