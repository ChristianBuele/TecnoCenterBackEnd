package com.edmarscenter.servidor.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edmarscenter.servidor.modelo.Mensaje;
import com.edmarscenter.servidor.modelo.Reparacion;
import com.edmarscenter.servidor.repositorio.ReparacionInterface;

@Controller
@RequestMapping("/")
public class ControladorReparacion {
	@Autowired
	ReparacionInterface reparacionInterface;
	
	@GetMapping("/reparacion")
	public ResponseEntity<List<Reparacion>> getReparaciones(){
		List<Reparacion> reparaciones=new ArrayList<Reparacion>();
		try {
			reparaciones=reparacionInterface.findAll();
			return new ResponseEntity<List<Reparacion>>(reparaciones,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Reparacion>>(reparaciones,HttpStatus.OK);
		}
	}
	
	@PostMapping("/reparacion")
	public ResponseEntity<Mensaje> addReparacion(@RequestBody Reparacion reparacion){
		System.out.println("Llega la repacion "+reparacion.getNombre());
		try {
			reparacionInterface.save(reparacion);
			return new ResponseEntity<Mensaje>(new Mensaje(false, "Reparacion Agregada Correctamente", "/reparacion"),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Mensaje>(new Mensaje(true, "Reparacion no agregada, Intente nuevamente\n"+e.getMessage(), "/reparacion"),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/reparacion/search/{cedula}")
	public ResponseEntity< List<Reparacion>> getReparacionesByCedula(@PathVariable(value="cedula")String cedula){
		System.out.println("Se busca la reparacion de "+cedula);
		List<Reparacion> reperaciones=new ArrayList<Reparacion>();
		try {
			reperaciones=reparacionInterface.findByCedulaUsuario(cedula);
			return new ResponseEntity<List<Reparacion>>(reperaciones ,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<List<Reparacion>>( reperaciones,HttpStatus.BAD_REQUEST);

		}
	}
	

}
