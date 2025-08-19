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
public class PartyAuthQuestionEvaluateResponse extends BaseResponse{
    private List<AuthenticationAnswers> authenticationAnswers;
}

