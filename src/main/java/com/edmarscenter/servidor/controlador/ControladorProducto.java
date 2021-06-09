package com.edmarscenter.servidor.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.edmarscenter.servidor.modelo.Producto;
import com.edmarscenter.servidor.modelo.CodigoBarra;
import com.edmarscenter.servidor.modelo.Mensaje;
import com.edmarscenter.servidor.repositorio.CodigoBarraInterface;
import com.edmarscenter.servidor.repositorio.ProductosInterface;

@RestController
@RequestMapping("/")
public class ControladorProducto {
	@Autowired
	ProductosInterface productosInterface;
	
	@Autowired
	CodigoBarraInterface codigoBarraInterface;

	@PostMapping("/producto")
	public Mensaje addCarrito(@RequestBody Producto producto) {
		System.out.println("Add producto "+producto);
		try {
			Producto productoNuevo=productosInterface.save(producto);//guardo el producto
			CodigoBarra codB=new CodigoBarra(productoNuevo.getLocal().getId_local(),productoNuevo.getId_producto());//genero el codigo de barras
			
			CodigoBarra nuevoCodigo=codigoBarraInterface.save(codB);//agrego el codigo de barras a la base de datos
			
			productoNuevo.setCodigoBarra(nuevoCodigo);//agrego el codigo al producto
			Producto m=productosInterface.save(productoNuevo);//actualizo el codigo en el producto
			
			System.out.println("El codigo de barra el el producto es "+m.getCodigoBarra().getId_codigoBarra());
			
			nuevoCodigo.setProducto(m);//agrego el producto al codigode barra
			CodigoBarra cod=codigoBarraInterface.save(nuevoCodigo);//actualizo el codigo de barras con el producto
			
			
			
			System.out.println(cod.getProducto().getId_producto());
			
			return new Mensaje(false,"Ok","/producto");
		} catch (Exception e) {
			// TODO: handle exception
			return new Mensaje(true,e.getMessage(),"/producto");
		}
	}

	@GetMapping("/producto/{id}")
	public Producto getProducto(@PathVariable(value = "id") Integer id) {
		System.out.println("Get producto");
		return productosInterface.findById(id).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Carrito no encontrado");
		});
	}
	
	@GetMapping("/producto")
	public ResponseEntity<List<Producto>> getAllProductos() {
		System.out.println("Get all productos");
		try {
			List<Producto> x=productosInterface.findAll();
			return new ResponseEntity<List<Producto>>(x,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Producto>>(new ArrayList<Producto>(),HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PutMapping("/producto")  
	private Mensaje update(@RequestBody Producto producto){
		System.out.println("update producto");
	try {
		productosInterface.save(producto);
		return new Mensaje(false,"Ok","/producto");
	} catch (Exception e) {
		// TODO: handle exception
		return new Mensaje(true,"No se a podido actualizar el producto","/producto");
	}
	
	}  

	@DeleteMapping(value = "/producto/{id}")
	public Mensaje deletePost(@PathVariable Integer id) {
		System.out.println("Delete Producto");
		try {
			productosInterface.deleteById(id);
			System.out.println("eliminado " + id);
			return new Mensaje(false, "Ok","/producto/"+id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error delete producto " + e);
			return new Mensaje(true, "Error al eliminar el producto","/producto/"+id);
		}

	}
}
