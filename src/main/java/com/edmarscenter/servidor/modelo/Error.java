package com.edmarscenter.servidor.modelo;

public class Error {
	private boolean error=false;
	private String mensaje;
	private String path;
	
	public Error(boolean error, String mensaje,String path) {
		super();
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
