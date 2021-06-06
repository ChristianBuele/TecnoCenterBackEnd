package com.edmarscenter.servidor.modelo;

import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name="local")
public class Local {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_local;
	private String nombre;
	private String telefono;
	
	@OneToMany(mappedBy="local")
	private Set<Producto> productos;
	
	@OneToMany(mappedBy="local")
	private Set<Redes> redes;
	
	@OneToMany(mappedBy="local")
	private Set<Empleado> empleados;
	
	@OneToOne(mappedBy = "local")
	private Gerente gerente;
	
	@ManyToOne
    @JoinColumn(name="id_administrador", nullable=false)
	private Administrador administrador;
}
