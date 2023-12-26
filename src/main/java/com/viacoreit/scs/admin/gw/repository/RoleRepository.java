package com.viacoreit.scs.admin.gw.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.viacoreit.scs.admin.gw.dto.RoleDto;
import com.viacoreit.scs.admin.gw.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String>  {
/**
    Optional<Role> findRoleById(Long role);

    @Query("SELECT new com.viacoreit.scs.admin.gw.dto.scr.RoleDto(r.id, r.description, r.code, r.module) FROM Role r ")
    List<RoleDto> findAllRoleDto();

    @Query("SELECT new com.viacoreit.scs.admin.gw.dto.scr.RoleDto(r.id, r.description, r.code, r.module) FROM Role r where module = :module")
    List<RoleDto> findAllByModule(String module);


    @Query("SELECT r FROM Role r where code = :code")
    Role findByCode(String code);
    */
}