package com.edmarscenter.servidor.repositorio;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.edmarscenter.servidor.modelo.Administrador;

public interface AdministradorInterface extends JpaRepositoryImplementation<Administrador, Integer>{
	public Administrador findByCorreo(String Correo);
}
