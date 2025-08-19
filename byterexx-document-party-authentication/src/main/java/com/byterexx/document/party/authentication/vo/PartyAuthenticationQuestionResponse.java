package com.byterexx.document.party.authentication.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartyAuthenticationQuestionResponse extends BaseResponse{
    private List<AuthenticationQuestion> authenticationQuestions;
}
