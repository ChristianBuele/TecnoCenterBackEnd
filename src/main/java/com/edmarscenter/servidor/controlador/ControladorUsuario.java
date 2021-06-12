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

import com.edmarscenter.servidor.modelo.*;
import com.edmarscenter.servidor.repositorio.UsuarioInterface;

@Controller
@RequestMapping("/")
public class ControladorUsuario {
	@Autowired
	UsuarioInterface usuarioInterface ;
	
	@PostMapping("/usuario")
	public ResponseEntity<Mensaje> addUsuario(@RequestBody Usuario usuario) {
		System.out.println("Llega el usuario "+usuario.getNombre());
		try {
			usuarioInterface.save(usuario);
			return new ResponseEntity<Mensaje>(new Mensaje(false,"Usuario Agregado Exitozamente","/usuario"),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Mensaje>(new Mensaje(true,e.getMessage(),"/usuario"),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/usuario/search/{cedula}")
	public ResponseEntity<Usuario> getUsuarioByCedula(@PathVariable(value = "cedula") String cedula) {
		try {
			Usuario us=usuarioInterface.findByCedula(cedula);
			return new ResponseEntity<Usuario>(us,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Usuario>(new Usuario(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
		List<Usuario> usuarios=new ArrayList<Usuario>();
		try {
			usuarios=usuarioInterface.findAll();
			return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.BAD_REQUEST);
		}
	}
}
