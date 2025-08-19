package com.byterexx.document.party.authentication.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartyAuthenticationRequest extends BaseRequest{
    private String customerReference;
    private String partyReference;
    private AuthenticationType authenticationType;
    private String token;
    private String password;
}
