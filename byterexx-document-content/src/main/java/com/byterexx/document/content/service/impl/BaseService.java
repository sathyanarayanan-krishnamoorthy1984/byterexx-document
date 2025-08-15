package com.byterexx.document.content.service.impl;

import com.byterexx.document.common.validator.service.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
    @Autowired
    protected FieldValidator fieldValidator;

    protected <T extends BaseResponse> T getSuccessResponse(T response, String requestId) {
        response.setResponseCode(EStatementErrorCode.SUCCESS.getResponseCode());
        response.setResponseId(requestId);
        response.setResponseDescription(EStatementErrorCode.SUCCESS.getResponseMessage());
        return response;
    }
}