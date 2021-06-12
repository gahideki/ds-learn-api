package com.devsuperior.dslearnbds.repository;

import com.devsuperior.dslearnbds.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
