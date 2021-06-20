package com.edmarscenter.servidor.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.edmarscenter.servidor.modelo.Mensaje;
import com.edmarscenter.servidor.modelo.Paquete;
import com.edmarscenter.servidor.modelo.Tipo;
import com.edmarscenter.servidor.repositorio.PaqueteInterface;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ControladorPaquetes {
	@Autowired
	PaqueteInterface paqueteInterface;
	
	@PostMapping("/paquete")
	public ResponseEntity<Mensaje> addUpdatePaquete(@RequestBody Paquete paquete) {
		System.out.println("Agregando un nuevo paquete");
		try {
			paqueteInterface.save(paquete);
			return new ResponseEntity<Mensaje>(new Mensaje(false, "Paquete agregado correctamente", "/paquete"),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Mensaje>(new Mensaje(true, e.getMessage(), "/paquete"),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/paquete")
	public ResponseEntity<List<Paquete>> addUpdatePaquete(@RequestBody Tipo tipo) {
		System.out.println("Agregando un nuevo paquete");
		List<Paquete> paquetes=new ArrayList<Paquete>();
		try {
			paquetes=paqueteInterface.findByTipo(tipo);
			return new ResponseEntity<List<Paquete>>(paquetes,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Paquete>>(paquetes,HttpStatus.BAD_REQUEST);
		}
	}

}
