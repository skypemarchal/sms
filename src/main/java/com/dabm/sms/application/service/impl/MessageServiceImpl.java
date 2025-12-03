package com.dabm.sms.application.service.impl;

import com.dabm.sms.infrastructure.web.dto.SmsRequest;
import com.dabm.sms.application.service.MessageService;
import com.dabm.sms.domain.model.Contact;
import com.dabm.sms.domain.model.Message;
import com.dabm.sms.domain.repository.MessageRepository;
import com.dabm.sms.infrastructure.client.NrsClient;
import com.dabm.sms.infrastructure.client.request.NrsSmsRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MessageServiceImpl implements MessageService {
    private final NrsClient nrsClient;
    private final MessageRepository messageRepository;

    public MessageServiceImpl(NrsClient nrsClient, MessageRepository messageRepository) {
        this.nrsClient = nrsClient;
        this.messageRepository = messageRepository;
    }

    @Override
    public Mono<Message> sendSms(Message message) {
//        NrsSmsRequest bodyRequest = new NrsSmsRequest();
//        bodyRequest.setFrom(request.getSenderId());
//        bodyRequest.setTo(new String[]{request.getDestinataire()});
//        bodyRequest.setMessage(request.getMessage());
//
//        Message message = new Message();
//        message.setContent(request.getMessage());
//        message.setContact(new Contact());
//        message.setSenderId(request.getSenderId());

        return this.saveMessage(message);
//        return nrsClient.sendMessage(bodyRequest)
//                .then(saveMessage(message));
    }

    @Override
    public Flux<Message> getMessages() {
        return messageRepository.getMessages();
    }

    public Mono<Message> saveMessage(Message message) {
        return messageRepository.saveMessage(message);
    }


}
