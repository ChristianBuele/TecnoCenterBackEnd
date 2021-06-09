package com.edmarscenter.servidor.modelo;

import java.io.Serializable;

public class Mensaje implements Serializable{
	private boolean error=false;
	private String mensaje;
	private String path;
	
	public Mensaje(boolean error, String mensaje,String path) {
		
		this.error = error;
		this.mensaje = mensaje;
		this.path=path;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
