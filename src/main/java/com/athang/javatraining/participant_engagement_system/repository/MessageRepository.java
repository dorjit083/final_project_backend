package com.athang.javatraining.participant_engagement_system.repository;

import com.athang.javatraining.participant_engagement_system.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
