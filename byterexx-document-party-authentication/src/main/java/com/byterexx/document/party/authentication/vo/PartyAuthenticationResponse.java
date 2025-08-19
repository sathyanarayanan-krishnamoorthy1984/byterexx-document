package com.byterexx.document.party.authentication.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartyAuthenticationResponse extends BaseResponse{
    private String partyAuthenticationId;
    private AuthResult authResult;
    private String token;
}
