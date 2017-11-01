package com.example.reserva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.reserva.model.Reserva;

/**
 * Created by jhosman on 27/10/2017.
 */
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
	
	@Query("SELECT r FROM Reserva r WHERE r.cedula = ?1")
    public List<Reserva> findCedula(String cedula);

}
