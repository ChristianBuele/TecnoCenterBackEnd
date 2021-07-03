package com.edmarscenter.servidor.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.edmarscenter.servidor.modelo.*;
import com.edmarscenter.servidor.repositorio.EmpleadoInterface;
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ControladorEmpleado {
	@Autowired
	EmpleadoInterface empleadoInterface;
	
	@PostMapping("/empleado")
	public Mensaje addUpdateEmpleado(@RequestBody Empleado empleado) {
		System.out.println("Agregando al empleado "+empleado.getNombre());
		try {
			Empleado existente=empleadoInterface.findByCorreo(empleado.getCorreo());
			
			if(existente==null) {
				System.out.println("No existe empleado registrado");
				Empleado nuevoEmpleado=empleadoInterface.save(empleado);
				return new Mensaje(false,"Ok","/empleado");
			}else {
				return new Mensaje(true,"El correo ya esta registrado","/empleado");
			}
		} catch (Exception e) {
			// TODO: handle exception]
			System.out.println("Si existe empleado registrado ");
			return new Mensaje(true,e.getMessage(),"/empleado");
		}
	}
	
	@DeleteMapping(value = "/empleado/{id}")
	public Mensaje deleteEmpleado(@PathVariable(value = "id")String id) {
		System.out.println("Delete Empleado con id="+id);
		Empleado emp=this.empleadoInterface.findById(Integer.parseInt(id)).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Carrito no encontrado");
		});;
		boolean x= emp.isActivo();
		if(x) {
			emp.setActivo(false);
		}else {
			emp.setActivo(true);
		}
		try {
			empleadoInterface.save(emp);
			return new Mensaje(false, "Ok","/empleado/");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error delete empleado " + e);
			return new Mensaje(true, e.getMessage(),"/producto/");
		}
	}
	
	@GetMapping("/empleado")
	public ResponseEntity<List<Empleado>> getAllProductosEmpleados(){
		System.out.println("Obteniendo Empleados");
		try {
			List<Empleado> x=empleadoInterface.findAll();
			return new ResponseEntity<List<Empleado>>(x,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error "+e.getMessage());
			return new ResponseEntity<List<Empleado>>(new ArrayList<Empleado>(),HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/empleado/login")
	public Map<String,Object> login(@RequestBody Empleado empleado) {
		System.out.println("Se va a loguear el empleado "+empleado.getCorreo());
		Empleado nuevo;
		try {
			nuevo=empleadoInterface.findByCorreo(empleado.getCorreo());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al obtener el empleado");
			nuevo=null;
		}
		if(nuevo!=null && nuevo.isActivo()) {
			if(nuevo.getContra().equals(empleado.getContra())) {
				System.out.println("Las contraseñas son correctas 1:"+nuevo.getContra());
				Map<String,Object> datos=new HashMap<String, Object>();
				datos.put("error", false);
				datos.put("datos", nuevo);
				return  datos;
			}else {
				System.out.println("La contraseña es incorrecta");
			}
		}
		System.out.println("No se encuentra o el usuario no esta activo");
		Map<String,Object> datos=new HashMap<String, Object>();
		datos.put("error",true);
		datos.put("datos", null);
		return datos;
	}
	@PutMapping("/empleado")
	public Mensaje updateEmpleado(@RequestBody Empleado empleado) {
		System.out.println("Actualizando el empleado");
		try {
			Empleado empleados=empleadoInterface.save(empleado);
			return new Mensaje(false, "Ok","/empleado/");
		} catch (Exception e) {
			// TODO: handle exception
			return new Mensaje(true, e.getMessage(),"/empleado/");
		}
	}
}
