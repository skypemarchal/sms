package com.dabm.sms.application.service;

import com.dabm.sms.domain.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    public Contact findContact(String phone) {
        Contact contact = new Contact();
        contact.setPhone(phone);
        contact.setFirstName("John");
        contact.setLastName("Doe");
        return contact;
    }
}
