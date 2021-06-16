package com.edmarscenter.servidor.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edmarscenter.servidor.modelo.Mensaje;
import com.edmarscenter.servidor.modelo.Tipo;
import com.edmarscenter.servidor.repositorio.TipoInterface;

@Controller
public class ControladorTipo {
	@Autowired
	TipoInterface tipoInterface;
	
	@PostMapping("tipo")
	public ResponseEntity<Mensaje> addUpdateTipo(@RequestBody Tipo tipo) {
		System.out.println("Agregando un nuevo tipo");
		try {
			tipoInterface.save(tipo);
			return new ResponseEntity<Mensaje>(new Mensaje(false, "Tipo de paquetePaquete agregado correctamente", "/paquete"),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Mensaje>(new Mensaje(true, e.getMessage(), "/tipo"),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/tipo")
	public ResponseEntity<List<Tipo>> getAllTipos(){
		System.out.println("Obteniendo todos los tipos");
		List<Tipo> tipos=new ArrayList<Tipo>();
		try {
			tipos=tipoInterface.findAll();
			return new ResponseEntity<List<Tipo>>(tipos,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Tipo>>(tipos,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/tipo")
	public ResponseEntity<Mensaje>  deleteTipo(@RequestBody Tipo tipo) {
		System.out.println("Agregando un nuevo tipo");
		try {
			tipoInterface.delete(tipo);
			return new ResponseEntity<Mensaje>(new Mensaje(false, "Tipo de paquete Paquete borrado correctamente", "/tipo"),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Mensaje>(new Mensaje(true, e.getMessage(), "/tipo"),HttpStatus.BAD_REQUEST);
		}
	}

}
