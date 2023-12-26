package com.viacoreit.scs.admin.gw.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.viacoreit.scs.admin.gw.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

	/**
	 * Devuelve un listado de factura activos
	 * 
	 * @param estado
	 * @return List<Factura>
	 */
	@Query("SELECT c FROM Factura c WHERE (:estado IS NULL OR c.estado = :estado) AND deleted = 0")
	public List<Factura> findByCriteria(Boolean estado);

}

