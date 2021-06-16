package com.edmarscenter.servidor.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edmarscenter.servidor.modelo.Mensaje;
import com.edmarscenter.servidor.modelo.Pago;
import com.edmarscenter.servidor.repositorio.PagoContratoInterface;

@Controller
public class ControladorPago {
	@Autowired
	PagoContratoInterface pagoContratoInterface;
	
	@PostMapping("/pago")
	public ResponseEntity<Mensaje> addUpdateContrato(@RequestBody Pago pago){
		System.out.println("Agregando nuevo contrato");
		try {
			pagoContratoInterface.save(pago);
			return new ResponseEntity<Mensaje>(new Mensaje(false,"Pago registrado correctamente","/pago"),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Mensaje>(new Mensaje(true, "El pago no pudo ser registrado", "/pago"),HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/pago")
	public ResponseEntity<List<Pago>> getAllPagos(){
		List<Pago> pagos= new ArrayList<>();
		try {
			pagos=pagoContratoInterface.findAll();
			return new ResponseEntity<List<Pago>>(pagos,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Pago>>(pagos,HttpStatus.BAD_REQUEST);
		}
	}
}
