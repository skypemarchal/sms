package com.dabm.sms.application.dto;

import lombok.Data;

@Data
public class SmsRequest {
    private String destinataire;
    private String senderId;
    private String message;
}
