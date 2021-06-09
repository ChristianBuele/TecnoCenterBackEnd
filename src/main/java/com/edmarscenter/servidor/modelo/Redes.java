package com.edmarscenter.servidor.modelo;

import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name="redes")
public class Redes implements Serializable{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id_red;
		private String nombre;
		private String link;
		
		@ManyToOne
	    @JoinColumn(name="id_local", nullable=false)
		private Local local;

		public int getId_red() {
			return id_red;
		}

		public void setId_red(int id_red) {
			this.id_red = id_red;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public Local getLocal() {
			return local;
		}

		public void setLocal(Local local) {
			this.local = local;
		}
		
		
}
