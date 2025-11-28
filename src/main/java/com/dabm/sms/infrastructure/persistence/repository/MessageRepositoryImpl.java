package com.dabm.sms.infrastructure.persistence.repository;

import com.dabm.sms.domain.model.Message;
import com.dabm.sms.domain.repository.MessageRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.dabm.sms.infrastructure.persistence.mapper.MessageMapper.MESSAGE_MAPPER;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private final MessageMongoRepository messageMongoRepository;

    public MessageRepositoryImpl(MessageMongoRepository messageMongoRepository) {
        this.messageMongoRepository = messageMongoRepository;
    }

    @Override
    public Mono<Message> saveMessage(Message message) {
        return this.messageMongoRepository.save(MESSAGE_MAPPER.toEntity(message))
                .map(MESSAGE_MAPPER::fromEntity);
    }

    @Override
    public Flux<Message> getMessages() {
        return this.messageMongoRepository.findAll().map(MESSAGE_MAPPER::fromEntity);
    }
}
