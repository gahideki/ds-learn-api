package com.devsuperior.dslearnbds.repository;

import com.devsuperior.dslearnbds.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

}
