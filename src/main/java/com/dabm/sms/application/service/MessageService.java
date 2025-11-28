package com.dabm.sms.application.service;

import com.dabm.sms.infrastructure.web.dto.SmsRequest;
import com.dabm.sms.domain.model.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MessageService {
    Mono<Message> sendSms(Message message);
    Flux<Message> getMessages();
}
