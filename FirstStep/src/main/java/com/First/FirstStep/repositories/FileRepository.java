package com.First.FirstStep.repositories;

import com.First.FirstStep.Model.Course;
import com.First.FirstStep.Model.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface FileRepository extends JpaRepository<Files, UUID> {
    List<Files> findByCourses(Course course);

    List<Files> findByFileNameLikeIgnoreCase(String keyword);
}
