package com.edmarscenter.servidor.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.edmarscenter.servidor.modelo.*;
import com.edmarscenter.servidor.repositorio.CodigoBarraInterface;
import com.edmarscenter.servidor.repositorio.ProductosInterface;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
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
			System.out.println("Guarda el producto "+productoNuevo.getId_producto());
			
			CodigoBarra codB=productoNuevo.getCodigoBarra();
			codB.setCodProducto(productoNuevo.getId_producto());
			codB.generarCodigo();
			
			CodigoBarra nuevoCodigo=codigoBarraInterface.save(codB);//agrego el codigo de barras a la base de datos
			
			productoNuevo.setCodigoBarra(nuevoCodigo);//agrego el codigo al producto
			Producto m=productosInterface.save(productoNuevo);//actualizo el codigo en el producto
			
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
			System.out.println("Error "+e.getMessage());
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
	///
	@Autowired
	CodigoBarraInterface codBarraInterface;
	
	@GetMapping("/producto/search/{codigo}")
	public ResponseEntity<Producto> getByCodigo(@PathVariable(value = "codigo")String codigo) {
		System.out.println("Get by codigo "+codigo);
		try {
			CodigoBarra cod=codBarraInterface.findByCodigoDeBarra(codigo);
			int idProducto=cod.getCodProducto();
			Producto pro=productosInterface.findById(idProducto).orElseGet(()->{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Carrito no encontrado");
			});
			return new ResponseEntity<Producto>(pro,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			
			return new ResponseEntity<Producto>(new Producto(),HttpStatus.NO_CONTENT);
		}
		
	}
	
	//productos disponibles a la venta
	
	@GetMapping("/producto/venta")
	public ResponseEntity<List<Producto>> getProductosVenta(){
		System.out.println("Se busca los productos para la venta");
		List<Producto> productos=new ArrayList<Producto>();
		try {
			productos = productosInterface.findByDisponibleVenta(true);
			return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<List<Producto>>(productos,HttpStatus.BAD_REQUEST);
			
		}
	}
}
