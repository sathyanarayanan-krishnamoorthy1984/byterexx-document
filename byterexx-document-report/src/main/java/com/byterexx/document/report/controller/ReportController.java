package com.byterexx.document.report.controller;

import com.byterexx.document.report.vo.BaseResponse;
import com.byterexx.document.report.vo.GetReportRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/PartyAuthentication")
@Slf4j
public class ReportController {

    @PostMapping("/Retrieve")
    public ResponseEntity<BaseResponse> create (
            @RequestHeader(name = "X-Request-Id") String requestId,
            @RequestHeader(name = "X-Auth-Username") String userName,
            @RequestBody GetReportRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        return new ResponseEntity<>(new BaseResponse(), HttpStatus.OK);
    }
}
