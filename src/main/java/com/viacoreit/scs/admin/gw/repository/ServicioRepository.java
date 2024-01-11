package com.viacoreit.scs.admin.gw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.viacoreit.scs.admin.gw.entity.Servicio;

public interface ServicioRepository extends JpaRepository <Servicio, Long>{
	
	/**
	 * Devuelve un listado de los clientes activos y no borrados
	 * 
	 * @param active
	 * @return List<Servicio>
	 */
	
	@Query ("SELECT s FROM Servicio s WHERE (:active IS NULL OR s.active = :active) AND deleted = 0")
	public List<Servicio> findByCriteria(Boolean active);

	Optional<Servicio> findById(Long servicioId);
	
}
