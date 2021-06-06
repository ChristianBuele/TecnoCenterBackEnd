package com.edmarscenter.servidor.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import com.edmarscenter.servidor.modelo.Producto;

public interface ProductosInterface extends JpaRepository<Producto, Integer> {
	
}
