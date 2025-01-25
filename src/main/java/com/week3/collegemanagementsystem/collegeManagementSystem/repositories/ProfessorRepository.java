package com.week3.collegemanagementsystem.collegeManagementSystem.repositories;

import com.week3.collegemanagementsystem.collegeManagementSystem.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
