package com.dabm.sms.infrastructure.persistence.repository;

import com.dabm.sms.infrastructure.persistence.entity.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageMongoRepository extends ReactiveMongoRepository<Message, String> {
}
