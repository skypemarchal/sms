package com.dabm.sms.controller;

import com.dabm.sms.domain.SmsRequest;
import com.dabm.sms.model.Message;
import com.dabm.sms.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/get-messages")
    public Mono<String> getMessages() {
        return Mono.just("Sended");
    }
    @PostMapping("/send-message")
    public Mono<ResponseEntity<Message>> sendMessage(@RequestBody SmsRequest request) {
        return messageService.sendSms(request).then(Mono.just(ResponseEntity.ok().build()));
    }
}
