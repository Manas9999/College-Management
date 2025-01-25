package com.week3.collegemanagementsystem.collegeManagementSystem.service;

import com.week3.collegemanagementsystem.collegeManagementSystem.repositories.*;
import org.springframework.stereotype.Service;
import com.week3.collegemanagementsystem.collegeManagementSystem.entities.*;
import java.util.List;

@Service
public class CollegeService {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final AdmissionRecordRepository admissionRecordRepository;

    public CollegeService(ProfessorRepository professorRepository, StudentRepository studentRepository,
                          SubjectRepository subjectRepository, AdmissionRecordRepository admissionRecordRepository) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.admissionRecordRepository = admissionRecordRepository;
    }

    // Methods for retrieving all records
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public List<AdmissionRecord> getAllAdmissionRecords() {
        return admissionRecordRepository.findAll();
    }

    // Methods for creating entities
    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public AdmissionRecord createAdmissionRecord(AdmissionRecord admissionRecord) {
        return admissionRecordRepository.save(admissionRecord);
    }

    // Methods for updating entities
    public Professor updateProfessor(Long id, Professor professor) {
        if (professorRepository.existsById(id)) {
            professor.setId(id);
            return professorRepository.save(professor);
        }
        throw new RuntimeException("Professor not found");
    }

    public Student updateStudent(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        throw new RuntimeException("Student not found");
    }

    public Subject updateSubject(Long id, Subject subject) {
        if (subjectRepository.existsById(id)) {
            subject.setId(id);
            return subjectRepository.save(subject);
        }
        throw new RuntimeException("Subject not found");
    }

    public AdmissionRecord updateAdmissionRecord(Long id, AdmissionRecord admissionRecord) {
        if (admissionRecordRepository.existsById(id)) {
            admissionRecord.setId(id);
            return admissionRecordRepository.save(admissionRecord);
        }
        throw new RuntimeException("Admission Record not found");
    }

    // Methods for deleting entities
    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

    public void deleteAdmissionRecord(Long id) {
        admissionRecordRepository.deleteById(id);
    }

    // Additional methods for assigning relationships
    public void assignProfessorToStudent(Long professorId, Long studentId) {
        Professor professor = professorRepository.findById(professorId).orElseThrow(() -> new RuntimeException("Professor not found"));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        student.getProfessors().add(professor);
        professor.getStudents().add(student);
        studentRepository.save(student);
        professorRepository.save(professor);
    }

    public void assignSubjectToStudent(Long subjectId, Long studentId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new RuntimeException("Subject not found"));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        student.getSubjects().add(subject);
        subject.getStudents().add(student);
        studentRepository.save(student);
        subjectRepository.save(subject);
    }
}
