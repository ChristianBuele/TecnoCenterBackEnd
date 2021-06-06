package com.edmarscenter.servidor.modelo;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="empleado")
public class Empleado {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_empleado;
	
	private String nombre;
	private String apellido;
	private String numero;
	private String correo;
	private boolean rol;
	
	@OneToMany(mappedBy="empleado")
	private Set<Venta> ventas;
	
	@ManyToOne
    @JoinColumn(name="id_local", nullable=false)
	private Local local;
	
	

	
	
}
