package com.byterexx.document.party.authentication.controller;

import com.byterexx.document.party.authentication.vo.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/PartyAuthentication")
public class PartyAuthenticationController {

    @GetMapping("/Evaluate/Customers/AuthTypes/{authType}/References/{reference}")
    public ResponseEntity<PartyAuthenticationResponse> evaluateCustomerSso(@PathVariable(name = "authType") String authType,
                                                                           @PathVariable(name = "reference") String reference) {
        PartyAuthenticationRequest request = new PartyAuthenticationRequest();
        request.setAuthenticationType(AuthenticationType.valueOf(authType));
        request.setCustomerReference(reference);
        return new ResponseEntity<>(new PartyAuthenticationResponse(), HttpStatus.OK);
    }

    @GetMapping("/Evaluate/Parties/AuthTypes/{authType}/References/{reference}")
    public ResponseEntity<PartyAuthenticationResponse> evaluatePartySso(@PathVariable(name = "authType") String authType,
                                                                        @PathVariable(name = "reference") String reference) {
        PartyAuthenticationRequest request = new PartyAuthenticationRequest();
        request.setAuthenticationType(AuthenticationType.valueOf(authType));
        request.setPartyReference(reference);
        return new ResponseEntity<>(new PartyAuthenticationResponse(), HttpStatus.OK);
    }

    @PostMapping("/Evaluate")
    public ResponseEntity<PartyAuthenticationResponse> evaluate(@RequestBody PartyAuthenticationRequest request) {
        return new ResponseEntity<>(new PartyAuthenticationResponse(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PartyAuthenticationResponse> update(@RequestBody PartyAuthenticationUpdateRequest request) {
        return new ResponseEntity<>(new PartyAuthenticationResponse(), HttpStatus.OK);
    }

    @GetMapping("/Questions/{partyAuthenticationId}") // no usages
    public ResponseEntity<PartyAuthenticationQuestionResponse> questions(@PathVariable(name = "partyAuthenticationId") String partyAuthenticationId) {
        return new ResponseEntity<>(new PartyAuthenticationQuestionResponse(), HttpStatus.OK);
    }

    @PostMapping("/Questions/{partyAuthenticationId}/Evaluate") // no usages
    public ResponseEntity<PartyAuthQuestionEvaluateResponse> questions(@PathVariable(name = "partyAuthenticationId") String partyAuthenticationId, @RequestBody PartyAuthQuestionEvaluateRequest request) {
        return new ResponseEntity<>(new PartyAuthQuestionEvaluateResponse(), HttpStatus.OK);
    }
}
