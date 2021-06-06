package com.edmarscenter.servidor.modelo;

import javax.persistence.*;

@Entity
@Table(name="imagen")
public class Imagen {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_imagen;
	@ManyToOne
    @JoinColumn(name="id_producto", nullable=false)
	private Producto producto;
	
	private String link;

}
