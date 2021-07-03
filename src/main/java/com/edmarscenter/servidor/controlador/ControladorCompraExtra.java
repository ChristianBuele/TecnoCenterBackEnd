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
import org.springframework.web.bind.annotation.RestController;

import com.edmarscenter.servidor.modelo.*;
import com.edmarscenter.servidor.repositorio.CompraExtraInterface;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class ControladorCompraExtra {
	@Autowired
	CompraExtraInterface compraExtraInterface;
	
	@PostMapping("/compraExtra")
	public ResponseEntity<Mensaje> compraExtra(@RequestBody List<CompraExtra> compras) {
		System.out.println("Se agrega la compra extra");
		try {
			for(int i=0;i<compras.size();i++) {
				compraExtraInterface.save(compras.get(i));
			}
			return new ResponseEntity<Mensaje>(new Mensaje(false, "Compras agregadas Exitosamente", "/compraExtra"),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("A ocurrido un error");
			return new ResponseEntity<Mensaje>(new Mensaje(true, "Compra No Agregada. Intente nuevamente", "/compraExtra"),HttpStatus.BAD_GATEWAY
				)	;
		}
	}
	
	@GetMapping("/compraExtra/{id_local}")
	public ResponseEntity<Iterable<CompraExtra>> getComprasExtra(@PathVariable(value = "id_local") Integer id_local){
		System.out.println("Buscando compras");
		try {
			Iterable<CompraExtra> compras= compraExtraInterface.findAllByIdLocal(id_local);
			System.out.println("Llegan las compras");
			for(CompraExtra c:compras) {
				System.out.println(c.getDescripcion());
			}
			
			return new ResponseEntity<Iterable<CompraExtra>>(compras,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("el error es"+e.getMessage());
			return new ResponseEntity<Iterable<CompraExtra>>( new ArrayList<>(),HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/compraExtra/empleado")//comprasextra por empleado
	public ResponseEntity<List<CompraExtra>> getComprasByEmpleado(@RequestBody Empleado empleado){
		System.out.println("Devolviendo las compras extra de "+empleado.getId_empleado());
		return new ResponseEntity<List<CompraExtra>>(this.compraExtraInterface.findByEmpleado(empleado),HttpStatus.OK);
	}
}
