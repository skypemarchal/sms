package com.dabm.sms.client.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NrsSmsRequest {
    private String[] to;
    private String from;
    private String message;
}
