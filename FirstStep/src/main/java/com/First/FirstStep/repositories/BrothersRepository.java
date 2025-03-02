package com.First.FirstStep.repositories;

import com.First.FirstStep.Model.Brothers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BrothersRepository extends JpaRepository<Brothers,Long> {
}
