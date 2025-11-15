package com.dabm.sms.application.service;

import com.dabm.sms.application.dto.SmsRequest;
import com.dabm.sms.domain.model.Message;
import reactor.core.publisher.Mono;

public interface MessageService {
    Mono<Message> sendSms(SmsRequest request);
}
