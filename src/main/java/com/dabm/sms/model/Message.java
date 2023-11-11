package com.dabm.sms.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("messages")
@Getter
@Setter
public class Message {
    @Id
    private String id;
    private String senderId;
    private String content;
    private LocalDate scheduleDate;
    private LocalDate expireDate;
    private Contact contact;
}
