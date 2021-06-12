package com.devsuperior.dslearnbds.repository;

import com.devsuperior.dslearnbds.model.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver, Long> {

}
