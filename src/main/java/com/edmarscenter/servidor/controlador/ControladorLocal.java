package com.edmarscenter.servidor.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edmarscenter.servidor.modelo.Local;
import com.edmarscenter.servidor.repositorio.LocalInterface;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ControladorLocal {
	@Autowired
	LocalInterface localInterface;
	@GetMapping("/local")
	public ResponseEntity<List<Local>> getAllProductosLocales(){
		System.out.println("Obteniendo Locales");
		try {
			List<Local> x=localInterface.findAll();
			System.out.println("llegan "+x.size()+" locales");
			return new ResponseEntity<List<Local>>(x,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println("Error "+e.getMessage());
			return new ResponseEntity<List<Local>>(new ArrayList<Local>(),HttpStatus.NO_CONTENT);
		}
	}
}
