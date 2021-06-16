package com.edmarscenter.servidor.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edmarscenter.servidor.modelo.Paquete;
import com.edmarscenter.servidor.modelo.Tipo;

public interface PaqueteInterface extends JpaRepository<Paquete, Integer> {
	public List<Paquete> findByTipo(Tipo tipo);

}
