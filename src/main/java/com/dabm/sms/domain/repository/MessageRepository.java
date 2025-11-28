package com.dabm.sms.domain.repository;

import com.dabm.sms.domain.model.Message;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MessageRepository {
    Mono<Message> saveMessage(Message message);
    Flux<Message> getMessages();
}
