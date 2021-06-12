package com.edmarscenter.servidor.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edmarscenter.servidor.modelo.Usuario;

public interface UsuarioInterface extends JpaRepository<Usuario, Integer>{
	public Usuario findByCedula(String cedula);

}
