package com.edmarscenter.servidor.controlador;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servidor")
public class Controlador {
	@GetMapping("/carrito")
	public String getAll(){
		return "hola";
	}
}
