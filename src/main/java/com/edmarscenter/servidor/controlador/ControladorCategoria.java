package com.edmarscenter.servidor.controlador;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.edmarscenter.servidor.modelo.*;
import com.edmarscenter.servidor.repositorio.CategoriaInterface;



@RestController
@RequestMapping("/")
public class ControladorCategoria {
	@Autowired
	CategoriaInterface categoriaInterface;
	
	@PostMapping("/categoria")
	public Mensaje addCategoria(@RequestBody Categoria categoria) {
		System.out.println("Se agrega una categoria "+categoria.getNombre());
		try {
			categoriaInterface.save(categoria);
			return new Mensaje(false,"Categoria agregada correctamente","/categoria");
		}catch (Exception e) {
			// TODO: handle exception
			return new Mensaje(true,e.getMessage(),"/categoria");
		}
	}
	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> getCategorias() {
		System.out.println("Se van las categorias");
		try {
			List<Categoria> categorias=categoriaInterface.findAll();
			return new ResponseEntity<List<Categoria>>(categorias,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new ArrayList<Categoria>(),HttpStatus.NO_CONTENT);
			
		}
		
	}
	
	@PutMapping("/categoria") 
	public Mensaje updateCategoria(@RequestBody Categoria categoria) {
		System.out.println("Se actualiza una categoria "+categoria.getNombre());
		try {
			categoriaInterface.save(categoria);
			return new Mensaje(false,"Actualizacion Exitosa","/categoria");
		}catch (Exception e) {
			// TODO: handle exception
			return new Mensaje(true,e.getMessage(),"/categoria");
		}
	}
//	
	@DeleteMapping(value = "/categoria/{id}")
	public ResponseEntity<Mensaje> deleteCategoria(@PathVariable Integer id) {
		System.out.println("Se borra una categoria "+id);
		try {
			categoriaInterface.deleteById(id);
			return new ResponseEntity<Mensaje>(new Mensaje(false,"Eliminacion Exitosa","/categoria"),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Mensaje>(new Mensaje(true,e.getMessage(),"/categoria"),HttpStatus.BAD_REQUEST);
		}
	}
}
