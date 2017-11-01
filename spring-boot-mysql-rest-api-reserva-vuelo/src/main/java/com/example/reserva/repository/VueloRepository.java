package com.example.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reserva.model.Vuelo;

/**
 * Created by jhosman on 27/10/2017.
 */
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
	
	/*@Query(value = "SELECT "
			  + "new com.example.reserva.model.dto.VueloDTO(v.id, v.origen, v.destino, 'Miercoles', v.fecha, v.hora, c.jornada," 
			  + "c.costo) "
	          + "FROM Vuelo v, Costodiajornada c")
	List<VueloDTO> vuelosDTO();*/
	
	/*@Query("SELECT new com.example.reserva.model.dto.VueloDTO(v.id, v.origen, v.destino, v.fecha, v.hora) FROM Vuelo v")
    List<VueloDTO> retrieveVueloAsDTO();*/
	
	
	
}
