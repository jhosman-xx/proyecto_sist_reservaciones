/**
 * 
 */
package com.example.reserva.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reserva.model.Reserva;
import com.example.reserva.model.Vuelo;
import com.example.reserva.repository.ReservaRepository;

/**
 * @author Lenovo
 *
 */

@RestController
@RequestMapping("/ws")
public class ReservaController {
	
	@Autowired
	ReservaRepository reservaRepository;
	
	
	
	@GetMapping("/reservas")
	public List<Reserva> getAllVuelos() {
		return reservaRepository.findAll();
	}


	@GetMapping("/reserva/{id}")
	public ResponseEntity<Reserva> getReservaById(@PathVariable(value = "id") Integer ReservaId) {
		Reserva reserva = reservaRepository.findOne(ReservaId);
		if (reserva == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(reserva);
	}
	
	@GetMapping("/reservac/{cedula}")
	public List<Reserva> getReservaByCedula(@PathVariable(value = "cedula") String cedula) {
		List<Reserva> reservas = reservaRepository.findCedula(cedula);
		return reservas;
	}

	@PostMapping("/creserva")
	public Reserva createReserva(@Valid @RequestBody Reserva reserva) {
		return reservaRepository.save(reserva);
	}

	@PutMapping("/ureserva/{id}")
	public ResponseEntity<Reserva> updateReserva(@PathVariable(value = "id") Integer ReservaId,
			@Valid @RequestBody Reserva reservaDetails) {
		Reserva reserva = reservaRepository.findOne(ReservaId);
		if (reserva == null) {
			return ResponseEntity.notFound().build();
		}
		reserva.setId(reservaDetails.getId());
		reserva.setCedula(reservaDetails.getCedula());
		reserva.setNombre(reservaDetails.getNombre());
		reserva.setFechaNacimiento(reservaDetails.getFechaNacimiento());
		reserva.setEstado(reservaDetails.getEstado());
		reserva.setFechaTransac(reservaDetails.getFechaTransac());
		Vuelo vuelo = new Vuelo();
		reservaDetails.setVueloid(vuelo);
		reserva.setVueloid(reservaDetails.getVueloid());
		Reserva updatedReserva = reservaRepository.save(reserva);
		return ResponseEntity.ok(updatedReserva);
	}

	@DeleteMapping("/dreserva/{id}")
	public ResponseEntity<Reserva> deleteVuelo(@PathVariable(value = "id") Integer ReservaId) {
		Reserva reserva = reservaRepository.findOne(ReservaId);
		if (reserva == null) {
			return ResponseEntity.notFound().build();
		}
		reservaRepository.delete(reserva);
		return ResponseEntity.ok().build();
	}
	
	

}
