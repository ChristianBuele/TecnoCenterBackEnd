package com.edmarscenter.servidor.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.edmarscenter.servidor.modelo.Producto;
import com.edmarscenter.servidor.modelo.Error;
import com.edmarscenter.servidor.repositorio.ProductosInterface;

@RestController
@RequestMapping("/")
public class ControladorProducto {
	@Autowired
	ProductosInterface productosInterface;

	@PostMapping("/producto")
	public boolean addCarrito(@RequestBody Producto producto) {
		System.out.println("Add producto");
		Producto pro = productosInterface.save(producto);
		if (producto != null) {
			return true;
		}
		return false;
	}

	@GetMapping("/producto/{id}")
	public Producto getProducto(@PathVariable(value = "id") Integer id) {
		System.out.println("Get producto");
		return productosInterface.findById(id).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Carrito no encontrado");
		});
	}
	
	@PutMapping("/producto")  
	private Error update(@RequestBody Producto producto){
		System.out.println("update producto");
	try {
		productosInterface.save(producto);
		return new Error(true,"Ok","/producto");
	} catch (Exception e) {
		// TODO: handle exception
		return new Error(false,"No se a podido actualizar el producto","/producto");
	}
	
	}  

	@DeleteMapping(value = "/producto/{id}")
	public Error deletePost(@PathVariable Integer id) {
		System.out.println("Delete Producto");
		try {
			productosInterface.deleteById(id);
			System.out.println("eliminado " + id);
			return new Error(false, "Ok","/producto/"+id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error delete producto " + e);
			return new Error(true, "Error al eliminar el producto","/producto/"+id);
		}

	}
}
