package com.byterexx.document.party.authentication.vo;

public enum AuthResult {
    BLOCK,
    CHALLENGE_Q4,
    CHALLENGE_EMAIL,
    CHALLENGE_SMS,
    CHALLENGE_PHONE_PIN,
    SUCCESS,
    RESET_PASSWORD
}
