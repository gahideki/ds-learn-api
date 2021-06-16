package com.devsuperior.dslearnbds.repository;

import com.devsuperior.dslearnbds.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
