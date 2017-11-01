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

import com.example.reserva.model.Vuelo;
import com.example.reserva.repository.VueloRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by jhosman on 27/10/2017.
 */
@RestController
@RequestMapping("/ws")
@JsonFormat
public class VueloController {

	@Autowired
	VueloRepository vueloRepository;

	@GetMapping("/vuelos")	
	public List<Vuelo> getAllVuelos() {
		List<Vuelo> vuelos = vueloRepository.findAll();
		return vuelos;
	}

	@GetMapping("/vuelo/{id}")
	public ResponseEntity<Vuelo> getVueloById(@PathVariable(value = "id") Integer vueloId) {
		Vuelo vuelo = vueloRepository.findOne(vueloId);
		if (vuelo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(vuelo);
	}

	@PostMapping("/cvuelo")
	public Vuelo createVuelo(@Valid @RequestBody Vuelo vuelo) {
		return vueloRepository.save(vuelo);
	}

	@PutMapping("/uvuelo/{id}")
	public ResponseEntity<Vuelo> updateVuelo(@PathVariable(value = "id") Integer vueloId,
			@Valid @RequestBody Vuelo vueloDetails) {
		Vuelo vuelo = vueloRepository.findOne(vueloId);
		if (vuelo == null) {
			return ResponseEntity.notFound().build();
		}
		vuelo.setId(vueloDetails.getId());
		vuelo.setOrigen(vueloDetails.getOrigen());
		vuelo.setDestino(vuelo.getDestino());
		vuelo.setFecha(vuelo.getFecha());
		vuelo.setHora(vuelo.getHora());
		vuelo.setCapacidad(vuelo.getCapacidad());
		vuelo.setDisponibilidad(vuelo.getDisponibilidad());
		Vuelo updatedVuelo = vueloRepository.save(vuelo);
		return ResponseEntity.ok(updatedVuelo);
	}

	@DeleteMapping("/dvuelos/{id}")
	public ResponseEntity<Vuelo> deleteVuelo(@PathVariable(value = "id") Integer vueloId) {
		Vuelo vuelo = vueloRepository.findOne(vueloId);
		if (vuelo == null) {
			return ResponseEntity.notFound().build();
		}

		vueloRepository.delete(vuelo);
		return ResponseEntity.ok().build();
	}
}