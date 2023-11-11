package com.dabm.sms.util;

import java.util.Base64;

public class Base64Encoder {
    public static String encodeStringToBase64(String originalString) {
        byte[] encodedBytes = Base64.getEncoder().encode(originalString.getBytes());
        return new String(encodedBytes);
    }
}
