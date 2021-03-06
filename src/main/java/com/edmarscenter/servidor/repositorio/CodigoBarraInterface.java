package com.edmarscenter.servidor.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edmarscenter.servidor.modelo.CodigoBarra;
import com.edmarscenter.servidor.modelo.Producto;

@RestController
@RequestMapping("/")
public interface CodigoBarraInterface extends JpaRepository<CodigoBarra, Integer>  {
	public CodigoBarra findByCodigoDeBarra(String nombre);
}
