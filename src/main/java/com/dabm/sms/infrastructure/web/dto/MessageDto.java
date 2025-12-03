package com.dabm.sms.infrastructure.web.dto;

public record MessageDto(String id, String sender, String content, String receiverName, String receiverPhone) {
}
