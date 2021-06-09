package com.edmarscenter.servidor.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edmarscenter.servidor.modelo.*;

public interface CategoriaInterface extends JpaRepository<Categoria, Integer> {

}
