package com.devsuperior.dslearnbds.repository;

import com.devsuperior.dslearnbds.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
