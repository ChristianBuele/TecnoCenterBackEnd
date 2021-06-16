package com.edmarscenter.servidor.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edmarscenter.servidor.modelo.Pago;

public interface PagoContratoInterface extends JpaRepository<Pago, Integer> {

}
