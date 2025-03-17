package com.First.FirstStep.repositories;

import com.First.FirstStep.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course , Long> {



    Course findByCourseName(String courseName);

    Optional<Object> findByCourseNameLikeIgnoreCase(String courseName);
}
