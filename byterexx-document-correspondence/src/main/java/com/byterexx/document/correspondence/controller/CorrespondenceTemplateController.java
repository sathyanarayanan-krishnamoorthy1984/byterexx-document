package com.byterexx.document.correspondence.controller;

import com.byterexx.document.common.exception.DocumentErrorCode;
import com.byterexx.document.common.exception.DocumentValidationException;
import com.byterexx.document.correspondence.service.CorrespondenceService;
import com.byterexx.document.correspondence.service.CorrespondenceServiceFactory;
import com.byterexx.document.correspondence.vo.BaseResponse;
import com.byterexx.document.correspondence.vo.configuration.GetCorrespondenceConfigurationResponse;
import com.byterexx.document.correspondence.vo.templates.*;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Correspondence/Templates")
@Slf4j
public class CorrespondenceTemplateController {

    @Autowired
    private CorrespondenceServiceFactory correspondenceServiceFactory;

    @PostMapping
    public ResponseEntity<CreateTemplateResponse> create(@RequestHeader(name = "X-Request-Id") String requestId,
                                                         @RequestHeader(name = "X-Auth-Username") String userName,
                                                         @RequestBody CreateTemplateRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        CreateTemplateResponse response = correspondenceServiceFactory.service(CorrespondenceService.CREATE_TEMPLATE, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{templateId}")
    public ResponseEntity<GetTemplateResponse> getByClientId(@RequestHeader(name = "X-Request-Id") String requestId,
                                                             @RequestHeader(name = "X-Auth-Username") String userName,
                                                             @PathParam("templateId") String templateId) {
        GetTemplateRequest request = new GetTemplateRequest();
        request.setRequestId(requestId);
        request.setTemplateId(templateId);
        request.setUserName(userName);
        GetTemplateResponse getTemplateResponse = correspondenceServiceFactory.service(CorrespondenceService.GET_TEMPLATE, request, null);
        return new ResponseEntity<>(getTemplateResponse, HttpStatus.OK);
    }

    @GetMapping("/Names/{templateName}")
    public ResponseEntity<GetCorrespondenceConfigurationResponse> getByCertName(@RequestHeader(name = "X-Request-Id") String requestId,
                                                                             @RequestHeader(name = "X-Auth-Username") String userName,
                                                                             @PathParam("templateName") String templateName) {
        GetTemplateRequest request = new GetTemplateRequest();
        request.setRequestId(requestId);
        request.setTemplateName(templateName);
        request.setUserName(userName);
        GetCorrespondenceConfigurationResponse getClientResponse = correspondenceServiceFactory.service(CorrespondenceService.GET_TEMPLATE, request, null);
        return new ResponseEntity<>(getClientResponse, HttpStatus.OK);
    }

    @PutMapping("/{templateId}")
    public ResponseEntity<BaseResponse> update(@RequestHeader(name = "X-Request-Id") String requestId,
                                               @RequestHeader(name = "X-Auth-Username") String userName,
                                               @PathParam("templateId") String templateId,
                                               @RequestBody UpdateTemplateRequest request) {
        request.setRequestId(requestId);
        request.setTemplateId(templateId);
        request.setUserName(userName);
        BaseResponse response = correspondenceServiceFactory.service(CorrespondenceService.UPDATE_TEMPLATE, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{templateId}")
    public ResponseEntity<BaseResponse> delete(@RequestHeader(name = "X-Request-Id") String requestId,
                                               @RequestHeader(name = "X-Auth-Username") String userName,
                                               @PathParam("templateId") String templateId,
                                               @PathVariable("deleteConfirmation") String deleteConfirmation) {
        if(StringUtils.equalsIgnoreCase(deleteConfirmation, "Y")) {
            throw new DocumentValidationException(DocumentErrorCode.MISSING_DELETE_CONFIRM);
        }
        DeleteTemplateRequest request = new DeleteTemplateRequest();
        request.setTemplateId(templateId);
        request.setUserName(userName);
        BaseResponse response = correspondenceServiceFactory.service(CorrespondenceService.DELETE_TEMPLATE, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
