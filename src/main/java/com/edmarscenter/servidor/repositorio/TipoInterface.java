package com.edmarscenter.servidor.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edmarscenter.servidor.modelo.Tipo;

public interface TipoInterface extends JpaRepository<Tipo, Integer>{

}
