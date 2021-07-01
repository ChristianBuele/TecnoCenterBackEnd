package com.edmarscenter.servidor.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edmarscenter.servidor.modelo.Local;

public interface LocalInterface extends JpaRepository<Local, Integer> {

}
