package com.athang.javatraining.participant_engagement_system.service;

import com.athang.javatraining.participant_engagement_system.model.Student;
import com.athang.javatraining.participant_engagement_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);

    }

    public String deleteStudent(int id) {
        studentRepository.deleteById(id);
        return "Deleted";
    }

public Student updateStudent(int id, Student updateStudent){
Student existingStudent = getStudentById(id);
existingStudent.setName(updateStudent.getName());
existingStudent.setActivityId(updateStudent.getActivityId());
existingStudent.setStartingDate(updateStudent.getStartingDate());
existingStudent.setEndingDate(updateStudent.getEndingDate());
existingStudent.setStatus(updateStudent.getStatus());
existingStudent.setComments(updateStudent.getComments());
existingStudent.setDuration(updateStudent.getDuration());
return studentRepository.save(existingStudent);

}

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student Found With ID: " + id));
    }
}
