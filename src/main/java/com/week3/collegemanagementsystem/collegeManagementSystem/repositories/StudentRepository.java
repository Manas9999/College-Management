package com.week3.collegemanagementsystem.collegeManagementSystem.repositories;

import com.week3.collegemanagementsystem.collegeManagementSystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository   extends JpaRepository<Student, Long> {
}
