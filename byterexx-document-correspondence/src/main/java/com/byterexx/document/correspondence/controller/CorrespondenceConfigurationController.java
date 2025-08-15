package com.byterexx.document.correspondence.controller;

import com.byterexx.document.common.exception.DocumentErrorCode;
import com.byterexx.document.common.exception.DocumentValidationException;
import com.byterexx.document.correspondence.service.CorrespondenceService;
import com.byterexx.document.correspondence.service.CorrespondenceServiceFactory;
import com.byterexx.document.correspondence.vo.BaseResponse;
import com.byterexx.document.correspondence.vo.configuration.*;
import jakarta.websocket.server.PathParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Correspondence/Configurations")
public class CorrespondenceConfigurationController {

    @Autowired
    private CorrespondenceServiceFactory correspondenceServiceFactory;

    @PostMapping
    public ResponseEntity<CreateCorrespondenceConfigurationResponse> create(@RequestHeader(name = "X-Request-Id") String requestId,
                                                                            @RequestHeader(name = "X-Auth-Username") String userName,
                                                                            @RequestBody CreateCorrespondenceConfigurationRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        CreateCorrespondenceConfigurationResponse response = correspondenceServiceFactory.service(CorrespondenceService.CREATE_CONFIGURATION, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/Clients/{clientId}")
    public ResponseEntity<GetCorrespondenceConfigurationResponse> getByClientId(@RequestHeader(name = "X-Request-Id") String requestId,
                                                                                @RequestHeader(name = "X-Auth-Username") String userName,
                                                                                @PathParam("clientId") String clientId) {
        GetCorrespondenceConfigurationRequest request = new GetCorrespondenceConfigurationRequest();
        request.setRequestId(requestId);
        request.setClientId(clientId);
        request.setUserName(userName);
        GetCorrespondenceConfigurationResponse getClientResponse = correspondenceServiceFactory.service(CorrespondenceService.GET_CONFIGURATION, request, null);
        return new ResponseEntity<>(getClientResponse, HttpStatus.OK);
    }

    @GetMapping("/CertificateNames/{clientCertName}")
    public ResponseEntity<GetCorrespondenceConfigurationResponse> getByCertName(@RequestHeader(name = "X-Request-Id") String requestId,
                                                                                @RequestHeader(name = "X-Auth-Username") String userName,
                                                                                @PathParam("clientCertName") String clientCertName) {
        GetCorrespondenceConfigurationRequest request = new GetCorrespondenceConfigurationRequest();
        request.setRequestId(requestId);
        request.setClientCertName(clientCertName);
        request.setUserName(userName);
        GetCorrespondenceConfigurationResponse getClientResponse = correspondenceServiceFactory.service(CorrespondenceService.GET_CONFIGURATION, request, null);
        return new ResponseEntity<>(getClientResponse, HttpStatus.OK);
    }

    @GetMapping("/Correspondences/Names/{correspondenceName}")
    public ResponseEntity<GetCorrespondenceConfigurationResponse> getByCorrespondenceName(@RequestHeader(name = "X-Request-Id") String requestId,
                                                                                          @RequestHeader(name = "X-Auth-Username") String userName,
                                                                                          @PathParam("correspondenceName") String correspondenceName) {
        GetCorrespondenceConfigurationRequest request = new GetCorrespondenceConfigurationRequest();
        request.setRequestId(requestId);
        request.setCorrespondenceName(correspondenceName);
        request.setUserName(userName);
        GetCorrespondenceConfigurationResponse getClientResponse = correspondenceServiceFactory.service(CorrespondenceService.GET_CONFIGURATION, request, null);
        return new ResponseEntity<>(getClientResponse, HttpStatus.OK);
    }

    @GetMapping("/{configurationId}")
    public ResponseEntity<GetCorrespondenceConfigurationResponse> getById(@RequestHeader(name = "X-Request-Id") String requestId,
                                                                          @RequestHeader(name = "X-Auth-Username") String userName,
                                                                          @PathParam("configurationId") String configurationId) {
        GetCorrespondenceConfigurationRequest request = new GetCorrespondenceConfigurationRequest();
        request.setRequestId(requestId);
        request.setCorrespondenceId(configurationId);
        request.setUserName(userName);
        GetCorrespondenceConfigurationResponse getClientResponse = correspondenceServiceFactory.service(CorrespondenceService.GET_CONFIGURATION, request, null);
        return new ResponseEntity<>(getClientResponse, HttpStatus.OK);
    }

    @PutMapping("/{configurationId} no usages")
    public ResponseEntity<BaseResponse> update(@RequestHeader(name = "X-Request-Id") String requestId,
                                               @RequestHeader(name = "X-Auth-Username") String userName,
                                               @PathParam("configurationId") String configurationId,
                                               @RequestBody UpdateCorrespondenceClientRequest request) {
        request.setRequestId(requestId);
        request.setConfigurationId(configurationId);
        request.setUserName(userName);
        BaseResponse response = correspondenceServiceFactory.service(CorrespondenceService.UPDATE_CONFIGURATION, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{configurationId} no usages")
    public ResponseEntity<BaseResponse> delete(@RequestHeader(name = "X-Request-Id") String requestId,
                                               @RequestHeader(name = "X-Auth-Username") String userName,
                                               @PathParam("configurationId") String configurationId,
                                               @PathVariable("deleteConfirmation") String deleteConfirmation) {
        if(StringUtils.equalsIgnoreCase(deleteConfirmation, "Y")) {
            throw new DocumentValidationException(DocumentErrorCode.MISSING_DELETE_CONFIRM);
        }
        DeleteCorrespondenceConfigurationRequest request = new DeleteCorrespondenceConfigurationRequest();
        request.setConfigurationId(configurationId);
        request.setUserName(userName);
        BaseResponse response = correspondenceServiceFactory.service(CorrespondenceService.UPDATE_CONFIGURATION, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


