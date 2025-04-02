package com.oneToMany.uni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneToMany.uni.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	
}
