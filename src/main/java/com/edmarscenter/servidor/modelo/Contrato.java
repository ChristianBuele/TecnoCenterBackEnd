package com.edmarscenter.servidor.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="contrato")
public class Contrato implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_contrato;
	
	private Date fecha_activacion;
	
	private Date fecha_renovacion;
	
	private boolean estado;
	
	@OneToMany(mappedBy="contrato")
	private Set<Pago> pagos;
	
	@ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name="id_empleado", nullable=false)
	private Empleado empleado;
	
	@ManyToOne
    @JoinColumn(name="id_paquete", nullable=false)
	private Paquete paquete;

	public int getId_contrato() {
		return id_contrato;
	}

	public void setId_contrato(int id_contrato) {
		this.id_contrato = id_contrato;
	}

	public Date getFecha_activacion() {
		return fecha_activacion;
	}

	public void setFecha_activacion(Date fecha_activacion) {
		this.fecha_activacion = fecha_activacion;
	}

	public Date getFecha_renovacion() {
		return fecha_renovacion;
	}

	public void setFecha_renovacion(Date fecha_renovacion) {
		this.fecha_renovacion = fecha_renovacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Set<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}
	
	
	
}
