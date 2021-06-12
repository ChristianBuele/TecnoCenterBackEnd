package com.edmarscenter.servidor.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edmarscenter.servidor.modelo.Empleado;


public interface EmpleadoInterface extends JpaRepository<Empleado, Integer>{
	public Empleado findByCorreo(String correo);
}
