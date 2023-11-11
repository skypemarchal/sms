package com.dabm.sms.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("contacts")
@Getter
@Setter
public class Contact {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
}
