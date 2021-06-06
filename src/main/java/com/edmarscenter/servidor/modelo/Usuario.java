package com.edmarscenter.servidor.modelo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_usuario;
	
	private String nombre;
	private String correo;
	private String telefono;
	
	
	
//	@ManyToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
//	List<Producto> productos;
}
