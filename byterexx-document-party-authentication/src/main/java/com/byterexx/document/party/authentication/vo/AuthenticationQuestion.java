package com.byterexx.document.party.authentication.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthenticationQuestion {
    private String questionId;
    private String question;
}
