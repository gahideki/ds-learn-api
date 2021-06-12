package com.devsuperior.dslearnbds.repository;

import com.devsuperior.dslearnbds.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
