package com.dabm.sms.service;

import com.dabm.sms.domain.SmsRequest;
import com.dabm.sms.model.Message;
import reactor.core.publisher.Mono;

public interface MessageService {
    Mono<Message> sendSms(SmsRequest request);
}
