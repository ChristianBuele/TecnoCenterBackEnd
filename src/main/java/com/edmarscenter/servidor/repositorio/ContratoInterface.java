package com.edmarscenter.servidor.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edmarscenter.servidor.modelo.Contrato;
import com.edmarscenter.servidor.modelo.Usuario;

public interface ContratoInterface extends JpaRepository<Contrato, Integer> {
	public List<Contrato> findByUsuario(Usuario usuario);

}
