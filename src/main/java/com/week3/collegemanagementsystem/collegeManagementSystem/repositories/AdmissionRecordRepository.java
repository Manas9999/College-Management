package com.week3.collegemanagementsystem.collegeManagementSystem.repositories;

import com.week3.collegemanagementsystem.collegeManagementSystem.entities.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecord, Long> {
}
