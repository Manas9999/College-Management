package com.week3.collegemanagementsystem.collegeManagementSystem.repositories;

import com.week3.collegemanagementsystem.collegeManagementSystem.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
