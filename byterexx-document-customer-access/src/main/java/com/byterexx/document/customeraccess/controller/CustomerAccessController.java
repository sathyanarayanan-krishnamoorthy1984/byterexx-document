package com.byterexx.document.customeraccess.controller;


import com.byterexx.document.common.exception.DocumentErrorCode;
import com.byterexx.document.common.exception.DocumentValidationException;
import com.byterexx.document.customeraccess.controller.vo.*;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CustomerAccessEntitlement")
@Slf4j
public class CustomerAccessController {

    @PostMapping
    public ResponseEntity<BaseResponse> create(
            @RequestHeader(name = "X-Request-Id") String requestId,
            @RequestHeader(name = "X-Auth-Username") String userName,
            @RequestBody CreateCustomerAccessRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        return new ResponseEntity<>(new BaseResponse(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(
            @RequestHeader(name = "X-Request-Id") String requestId,
            @RequestHeader(name = "X-Auth-Username") String userName,
            @RequestBody CreateCustomerAccessRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        return new ResponseEntity<>(new BaseResponse(), HttpStatus.OK);
    }

    @DeleteMapping("/Clients/{clientId}/Users/{userId}")
    public ResponseEntity<BaseResponse> delete(
            @RequestHeader(name = "X-Request-Id") String requestId,
            @RequestHeader(name = "X-Auth-Username") String userName,
            @PathParam("clientId") String clientId,
            @PathParam("userId") String userId,
            @PathVariable("deleteConfirmation") String deleteConfirmation) {
        DeleteCustomerAccessRequest request = new DeleteCustomerAccessRequest();
        request.setRequestId(requestId);
        request.setUserName(userName);
        request.setClientId(clientId);
        request.setUserId(userId);
        if (StringUtils.equalsIgnoreCase(deleteConfirmation, "Y")) {
            throw new DocumentValidationException(DocumentErrorCode.MISSING_DELETE_CONFIRM);
        }
        return new ResponseEntity<>(new BaseResponse(), HttpStatus.OK);
    }

    @GetMapping("/Retrieve")
    public ResponseEntity<GetCustomerAccessResponse> get(
            @RequestHeader(name = "X-Request-Id") String requestId,
            @RequestHeader(name = "X-Auth-Username") String userName,
            @RequestBody GetCustomerAccessRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        return new ResponseEntity<>(new GetCustomerAccessResponse(), HttpStatus.OK);
    }
}