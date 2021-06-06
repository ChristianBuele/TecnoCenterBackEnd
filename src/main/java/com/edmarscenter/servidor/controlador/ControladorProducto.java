package com.edmarscenter.servidor.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.edmarscenter.servidor.modelo.Producto;
import com.edmarscenter.servidor.repositorio.ProductosInterface;

@RestController
@RequestMapping("/producto")
public class ControladorProducto {
	@Autowired
	ProductosInterface productosInterface;
	@GetMapping("/")
	public Iterable<Producto> getAll(){
		return productosInterface.findAll();
	}
}
