package com.viacoreit.scs.admin.gw.repository;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.viacoreit.scs.admin.gw.entity.Auditoria;

@Repository
public interface AuditoriaRepository extends JpaRepository <Auditoria, Long>{
		
	@Query ("FROM Auditoria au WHERE (:startDate is null or au.hora > :startDate) AND (:endDate is null or au.hora < :endDate)")
	List<Auditoria> findByCriterios(Timestamp startDate , Timestamp endDate);
	
}
