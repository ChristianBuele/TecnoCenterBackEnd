package com.edmarscenter.servidor.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edmarscenter.servidor.modelo.CompraExtra;

public interface CompraExtraInterface extends JpaRepository<CompraExtra, Integer>{
	@Query(value="SELECT * FROM Compra_Extra c",nativeQuery = true)
	public List<CompraExtra> findAllByIdLocal(int id_local);
}
