package com.viacoreit.scs.admin.gw.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.viacoreit.scs.admin.gw.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Devuelve un listado de usuarios activos
	 * 
	 * @param active
	 * @return List<User>
	 */
	@Query("SELECT u FROM User u WHERE (:active IS NULL OR u.active = :active) AND (:password IS NULL OR u.password = :password) AND (:name IS NULL OR u.name = :name) AND deleted = 0")
	public List<User> findByCriteria(Boolean active, String password, String name);

}