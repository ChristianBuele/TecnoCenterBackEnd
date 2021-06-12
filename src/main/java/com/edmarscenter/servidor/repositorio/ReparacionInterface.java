package com.edmarscenter.servidor.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edmarscenter.servidor.modelo.Reparacion;

public interface ReparacionInterface extends JpaRepository<Reparacion, Integer> {
	@Query(value="SELECT r.id_reparacion,r.nombre,r.precio,r.descripcion,r.fecha_ingreso,r.reparado,r.id_empleado,r.entregado,r.fecha_salida, u.id_usuario FROM reparacion r join usuario u on r.id_usuario=u.id_usuario where u.cedula=?1 ",nativeQuery = true)
	public List<Reparacion> findByCedulaUsuario(String cedula);
}
