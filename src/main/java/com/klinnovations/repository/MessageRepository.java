package com.klinnovations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klinnovations.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
