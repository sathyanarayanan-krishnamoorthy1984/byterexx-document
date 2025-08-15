package com.byterexx.document.correspondence.controller;

import com.byterexx.document.correspondence.service.CorrespondenceService;
import com.byterexx.document.correspondence.service.CorrespondenceServiceFactory;
import com.byterexx.document.correspondence.vo.BaseResponse;
import com.byterexx.document.correspondence.vo.outbound.CreateCorrespondenceRequest;
import com.byterexx.document.correspondence.vo.outbound.CreateCorrespondenceResponse;
import com.byterexx.document.correspondence.vo.outbound.GetCorrespondenceRequest;
import com.byterexx.document.correspondence.vo.outbound.UpdateCorrespondenceRequest;
import com.byterexx.document.correspondence.vo.templates.CreateTemplateResponse;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Correspondence/Outbound")
@Slf4j
public class CorrespondenceController {
    @Autowired
    private CorrespondenceServiceFactory correspondenceServiceFactory;

    @PostMapping("/{id}")
    public ResponseEntity<CreateCorrespondenceResponse> create(
            @RequestHeader(name = "X-Request-Id") String requestId,
            @RequestHeader(name = "X-Client-Cert-Name") String clientCertName,
            @RequestHeader(name = "X-App-Name") String applicationName,
            @PathParam("id") String id,
            @RequestBody CreateCorrespondenceRequest request) {
        request.setRequestId(requestId);
        request.setApplicationName(applicationName);
        request.setId(id);
        request.setClientCertName(clientCertName);
        CreateCorrespondenceResponse response =  correspondenceServiceFactory.service(CorrespondenceService.CREATE_CORRESPONDENCE, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> update(
            @RequestHeader(name = "X-Request-Id") String requestId,
            @RequestHeader(name = "X-Client-Cert-Name") String clientCertName,
            @RequestHeader(name = "X-App-Name") String applicationName,
            @PathParam("id") String id,
            @RequestBody UpdateCorrespondenceRequest request) {
        request.setRequestId(requestId);
        request.setApplicationName(applicationName);
        request.setId(id);
        request.setClientCertName(clientCertName);
        BaseResponse response = correspondenceServiceFactory.service(CorrespondenceService.UPDATE_CORRESPONDENCE, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateTemplateResponse> get(@RequestHeader(name = "X-Request-Id") String requestId,
                                                      @RequestHeader(name = "X-Client-Cert-Name") String clientCertName,
                                                      @RequestHeader(name = "X-App-Name") String applicationName,
                                                      @PathParam("id") String id) {
        GetCorrespondenceRequest request = new GetCorrespondenceRequest();
        request.setRequestId(requestId);
        request.setId(id);
        request.setApplicationName(applicationName);
        request.setClientCertName(clientCertName);
        CreateTemplateResponse response = correspondenceServiceFactory.service(CorrespondenceService.GET_CORRESPONDENCE, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/Batches/{batchId}")
    public ResponseEntity<CreateTemplateResponse> getByBatchId(@RequestHeader(name = "X-Request-Id") String requestId,
                                                               @RequestHeader(name = "X-Client-Cert-Name") String clientCertName,
                                                               @RequestHeader(name = "X-App-Name") String applicationName,
                                                               @PathParam("batchId") String batchId) {
        GetCorrespondenceRequest request = new GetCorrespondenceRequest();
        request.setRequestId(requestId);
        request.setApplicationName(applicationName);
        request.setBatchId(batchId);
        request.setClientCertName(clientCertName);
        CreateTemplateResponse response = correspondenceServiceFactory.service(CorrespondenceService.GET_CORRESPONDENCE, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
