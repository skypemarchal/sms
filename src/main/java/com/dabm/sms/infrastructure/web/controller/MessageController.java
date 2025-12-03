package com.dabm.sms.infrastructure.web.controller;

import com.dabm.sms.application.service.ContactService;
import com.dabm.sms.application.service.MessageService;
import com.dabm.sms.domain.model.Contact;
import com.dabm.sms.infrastructure.web.dto.MessageDto;
import com.dabm.sms.infrastructure.web.dto.SmsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

import static com.dabm.sms.infrastructure.web.mapper.MessageMapper.MESSAGE_MAPPER;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;
    private final ContactService contactService;

    public MessageController(MessageService messageService, ContactService contactService) {
        this.messageService = messageService;
        this.contactService = contactService;
    }

    @GetMapping("/messages")
    public Mono<ResponseEntity<List<MessageDto>>> getMessages() {
        return messageService.getMessages()
                .map(MESSAGE_MAPPER::toDto)
                .collectList()
                .map(ResponseEntity::ok);
    }

    @PostMapping("/messages")
    public Mono<ResponseEntity<MessageDto>> sendMessage(@RequestBody SmsRequest request) {
        Contact contact = contactService.findContact(request.getPhone());
        return messageService.sendSms(MESSAGE_MAPPER.fromDto(request, contact))
                .map(message -> {
                    URI location = URI.create("/messages/" + message.getId());
                    return ResponseEntity
                            .created(location)
                            .body(MESSAGE_MAPPER.toDto(message));
                });
    }
}
