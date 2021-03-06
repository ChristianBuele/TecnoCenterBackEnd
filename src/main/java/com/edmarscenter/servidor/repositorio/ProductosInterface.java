package com.edmarscenter.servidor.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edmarscenter.servidor.modelo.Producto;

public interface ProductosInterface extends JpaRepository<Producto, Integer> {
	public Producto findByCodigoBarra(String nombre);
	
	public List<Producto> findByDisponibleVenta(boolean dis);
}
