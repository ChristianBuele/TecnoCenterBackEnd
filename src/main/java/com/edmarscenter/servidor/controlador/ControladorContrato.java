package com.edmarscenter.servidor.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edmarscenter.servidor.modelo.Contrato;
import com.edmarscenter.servidor.modelo.Mensaje;
import com.edmarscenter.servidor.modelo.Usuario;
import com.edmarscenter.servidor.repositorio.ContratoInterface;
import com.edmarscenter.servidor.repositorio.UsuarioInterface;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class ControladorContrato {

	@Autowired
	ContratoInterface contratoInterface;
	@Autowired 
	UsuarioInterface UsuarioInterface;
	
	@PostMapping("/contrato")
	public ResponseEntity<Mensaje> addContrato(@RequestBody Contrato contrato){
		System.out.println("Se crea un nuevo contrato");
		try {
			contratoInterface.save(contrato);
			return new ResponseEntity<Mensaje>(new Mensaje(false,"Contato creado correctamente","/contrato"),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Mensaje>(new Mensaje(true,e.getMessage(),"/contrato"),HttpStatus.OK);
			// TODO: handle exception
		}
	}
	@GetMapping("/contrato/{cedula}")
	public ResponseEntity<List<Contrato>> getContratoByCedula(@PathVariable(value = "cedula")String cedula){
		System.out.println("Obteniendo los contratos");
		List<Contrato> contratos=new ArrayList<Contrato>();
		try {
			Usuario usuario=UsuarioInterface.findByCedula(cedula);
			if(usuario!=null) {
				System.out.println("Se encuentra al usuario "+usuario.getNombre());
				contratos=contratoInterface.findByUsuario(usuario);
				return new ResponseEntity<List<Contrato>>(contratos,HttpStatus.OK);
			}
			return new ResponseEntity<List<Contrato>>(contratos,HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Contrato>>(contratos,HttpStatus.BAD_REQUEST);
		}
		
	}
}
