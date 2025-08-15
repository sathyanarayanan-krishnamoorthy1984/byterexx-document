package com.byterexx.document.correspondence.controller;


import com.byterexx.document.correspondence.service.CorrespondenceService;
import com.byterexx.document.correspondence.service.CorrespondenceServiceFactory;
import com.byterexx.document.correspondence.vo.audit.GetAuditRequest;
import com.byterexx.document.correspondence.vo.audit.GetAuditResponse;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Correspondence/Audits")
@Slf4j
public class CorrespondenceAuditController {

    @Autowired
    private CorrespondenceServiceFactory correspondenceServiceFactory;

    @PostMapping("/Retrieve")
    public ResponseEntity<GetAuditResponse> get(@RequestHeader(name = "X-Request-Id") String requestId,
                                                @RequestHeader(name = "X-Auth-Username") String userName,
                                                @PathParam("clientId") String clientId,
                                                @RequestBody GetAuditRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        GetAuditResponse getClientResponse = correspondenceServiceFactory.service(CorrespondenceService.GET_AUDIT, request, null);
        return new ResponseEntity<>(getClientResponse, HttpStatus.OK);
    }
}