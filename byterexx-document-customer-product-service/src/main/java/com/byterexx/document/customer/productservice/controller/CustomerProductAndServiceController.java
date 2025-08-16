package com.byterexx.document.customer.productservice.controller;

import com.byterexx.document.customer.productservice.vo.BaseResponse;
import com.byterexx.document.customer.productservice.vo.CustomerProductAndServiceRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerProductAndServiceController {

    @PostMapping
    public ResponseEntity<BaseResponse> create (
            @RequestHeader(name = "X-Request-Id") String requestId,
            @RequestHeader(name = "X-Auth-Username") String userName,
            @RequestBody CustomerProductAndServiceRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        return new ResponseEntity<>(new BaseResponse(), HttpStatus.OK);
    }

}
