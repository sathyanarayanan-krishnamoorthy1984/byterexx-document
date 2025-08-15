package com.byterexx.document.correspondence.service.impl;

import com.byterexx.document.common.exception.DocumentErrorCode;
import com.byterexx.document.common.validator.service.FieldValidator;
import com.byterexx.document.correspondence.vo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BaseService {
    @Autowired
    protected FieldValidator fieldValidator;

    @Autowired
    protected DocumentAuditRepository correspondenceAuditRepository;

    protected <T extends BaseResponse> T getSuccessResponse(T response, String requestId) {
        response.setResponseCode(DocumentErrorCode.SUCCESS.getResponseCode());
        response.setResponseId(requestId);
        response.setResponseDescription(DocumentErrorCode.SUCCESS.getResponseMessage());
        return response;
    }
}