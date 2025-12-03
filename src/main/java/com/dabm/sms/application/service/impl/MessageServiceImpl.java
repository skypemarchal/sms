package com.dabm.sms.application.service.impl;

import com.dabm.sms.infrastructure.client.NrsClient;
import com.dabm.sms.infrastructure.client.request.NrsSmsRequest;
import com.dabm.sms.application.dto.SmsRequest;
import com.dabm.sms.domain.model.Contact;
import com.dabm.sms.domain.model.Message;
import com.dabm.sms.domain.repository.MessageRepository;
import com.dabm.sms.application.service.MessageService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MessageServiceImpl implements MessageService {
    private final NrsClient nrsClient;
    private final MessageRepository messageRepository;

    public MessageServiceImpl(NrsClient nrsClient, MessageRepository messageRepository) {
        this.nrsClient = nrsClient;
        this.messageRepository = messageRepository;
    }

    public Mono<Message> sendSms(SmsRequest request) {
        NrsSmsRequest bodyRequest = new NrsSmsRequest();
        bodyRequest.setFrom(request.getSenderId());
        bodyRequest.setTo(new String[]{request.getDestinataire()});
        bodyRequest.setMessage(request.getMessage());

        Message message = new Message();
        message.setContent(request.getMessage());
        message.setContact(new Contact());
        message.setSenderId(request.getSenderId());

        return nrsClient.sendMessage(bodyRequest)
                .then(saveMessage(message));
    }

    public Mono<Message> saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
