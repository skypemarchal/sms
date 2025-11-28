package com.dabm.sms.infrastructure.web.dto;

import lombok.Data;

@Data
public class SmsRequest {
    private String destinataire;
    private String senderId;
    private String message;
    private String phone;
}
