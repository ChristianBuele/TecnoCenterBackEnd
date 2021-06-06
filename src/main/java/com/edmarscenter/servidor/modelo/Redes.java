package com.edmarscenter.servidor.modelo;

import javax.persistence.*;
@Entity
@Table(name="redes")
public class Redes {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id_red;
		private String nombre;
		private String link;
		
		@ManyToOne
	    @JoinColumn(name="id_local", nullable=false)
		private Local local;
}
