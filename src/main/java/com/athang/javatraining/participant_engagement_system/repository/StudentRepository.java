package com.athang.javatraining.participant_engagement_system.repository;

import com.athang.javatraining.participant_engagement_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
