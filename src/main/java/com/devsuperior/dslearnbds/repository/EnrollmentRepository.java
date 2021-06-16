package com.devsuperior.dslearnbds.repository;

import com.devsuperior.dslearnbds.model.Enrollment;
import com.devsuperior.dslearnbds.model.pk.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {

}
