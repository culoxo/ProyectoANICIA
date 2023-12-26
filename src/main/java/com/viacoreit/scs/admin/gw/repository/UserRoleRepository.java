package com.viacoreit.scs.admin.gw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.viacoreit.scs.admin.gw.dto.UserAdminDto;
import com.viacoreit.scs.admin.gw.dto.UserDTO;
import com.viacoreit.scs.admin.gw.entity.User;
import com.viacoreit.scs.admin.gw.entity.UserRole;

/**
 * Repositorio de la clase {@link User}
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {


/**
    @Query("SELECT ur FROM UserRole ur where ur.userid = :userid AND ur.role.module = :module")
    Optional<UserRole> findByUserAndModule(Long userid, String module);

    @Query("SELECT ur FROM UserRole ur where ur.userid = :userid")
    Optional<UserRole> findByUser(Long userid);

    @Query("SELECT ur FROM UserRole ur where ur.userid = :userid")
    List<UserRole> findUserRolesByUser(Long userid);
    */
}
