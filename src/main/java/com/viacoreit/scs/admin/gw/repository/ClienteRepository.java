package com.viacoreit.scs.admin.gw.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.viacoreit.scs.admin.gw.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	/**
	 * Devuelve un listado de clientes activos
	 * 
	 * @param active
	 * @return List<Cliente>
	 */
	@Query("SELECT c FROM Cliente c WHERE (:active IS NULL OR c.active = :active) AND deleted = 0")
	public List<Cliente> findByCriteria(Boolean active);

}
