package com.week3.collegemanagementsystem.collegeManagementSystem.controllers;

import  com.week3.collegemanagementsystem.collegeManagementSystem.entities.*;
import com.week3.collegemanagementsystem.collegeManagementSystem.service.*;
import com.week3.collegemanagementsystem.collegeManagementSystem.service.CollegeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CollegeController {

    private final CollegeService collegeService;

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping("/professors")
    public List<Professor> getAllProfessors() {
        return collegeService.getAllProfessors();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return collegeService.getAllStudents();
    }

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {
        return collegeService.getAllSubjects();
    }

    @GetMapping("/admissionRecords")
    public List<AdmissionRecord> getAllAdmissionRecords() {
        return collegeService.getAllAdmissionRecords();
    }

    @PostMapping("/assign/professor-to-student")
    public void assignProfessorToStudent(@RequestParam Long professorId, @RequestParam Long studentId) {
        collegeService.assignProfessorToStudent(professorId, studentId);
    }

    @PostMapping("/assign/subject-to-student")
    public void assignSubjectToStudent(@RequestParam Long subjectId, @RequestParam Long studentId) {
        collegeService.assignSubjectToStudent(subjectId, studentId);
    }

    // New API to create Professor
    @PostMapping("/professors")
    public Professor createProfessor(@RequestBody Professor professor) {
        return collegeService.createProfessor(professor);
    }

    // New API to create Student
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return collegeService.createStudent(student);
    }

    // New API to create Subject
    @PostMapping("/subjects")
    public Subject createSubject(@RequestBody Subject subject) {
        return collegeService.createSubject(subject);
    }

    // New API to create AdmissionRecord
    @PostMapping("/admissionRecords")
    public AdmissionRecord createAdmissionRecord(@RequestBody AdmissionRecord admissionRecord) {
        return collegeService.createAdmissionRecord(admissionRecord);
    }

    // New API to update Professor
    @PutMapping("/professors/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        return collegeService.updateProfessor(id, professor);
    }

    // New API to update Student
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return collegeService.updateStudent(id, student);
    }

    // New API to update Subject
    @PutMapping("/subjects/{id}")
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
        return collegeService.updateSubject(id, subject);
    }

    // New API to update AdmissionRecord
    @PutMapping("/admissionRecords/{id}")
    public AdmissionRecord updateAdmissionRecord(@PathVariable Long id, @RequestBody AdmissionRecord admissionRecord) {
        return collegeService.updateAdmissionRecord(id, admissionRecord);
    }

    // New API to delete Professor
    @DeleteMapping("/professors/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        collegeService.deleteProfessor(id);
    }

    // New API to delete Student
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        collegeService.deleteStudent(id);
    }

    // New API to delete Subject
    @DeleteMapping("/subjects/{id}")
    public void deleteSubject(@PathVariable Long id) {
        collegeService.deleteSubject(id);
    }

    // New API to delete AdmissionRecord
    @DeleteMapping("/admissionRecords/{id}")
    public void deleteAdmissionRecord(@PathVariable Long id) {
        collegeService.deleteAdmissionRecord(id);
    }
}
