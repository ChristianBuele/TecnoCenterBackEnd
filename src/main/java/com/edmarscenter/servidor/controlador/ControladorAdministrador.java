package com.edmarscenter.servidor.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edmarscenter.servidor.modelo.Administrador;
import com.edmarscenter.servidor.modelo.Mensaje;
import com.edmarscenter.servidor.repositorio.AdministradorInterface;

@Controller
@RequestMapping("/")
public class ControladorAdministrador {
	@Autowired
	AdministradorInterface administradorInterface;
	
	@PostMapping("/administrador/login")
	public Administrador loginAdmin(@RequestBody Administrador administrador) {
		Administrador admin;
		try {
			admin=administradorInterface.findByCorreo(administrador.getCorreo());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		if(admin!=null && administrador.getContra().equals(admin.getContra())) {
			return admin;
		}
		return null;
	}
	
	@PostMapping("/administrador")
	public Mensaje updateAdministrador (@RequestBody Administrador administrador) {
		try {
				administradorInterface.save(administrador);
				return new Mensaje(false,"Datos actualizados","/administrador");
		} catch (Exception e) {
			// TODO: handle exception
			return new Mensaje(true,e.getMessage(),"/administrador");
		}
	}

}
