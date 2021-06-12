package com.devsuperior.dslearnbds.repository;

import com.devsuperior.dslearnbds.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

}
