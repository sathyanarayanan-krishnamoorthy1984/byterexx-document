package com.byterexx.document.correspondence.service.impl.configuration;

import com.byterexx.document.common.exception.DocumentValidationException;
import com.byterexx.document.common.utils.JsonUtil;
import com.byterexx.document.correspondence.exception.CorrespondenceErrorCode;
import com.byterexx.document.correspondence.interfaces.db.domain.CorrespondenceConfiguration;
import com.byterexx.document.correspondence.interfaces.db.domain.DocumentAudit;
import com.byterexx.document.correspondence.interfaces.db.persistence.CorrespondenceConfigurationRepository;
import com.byterexx.document.correspondence.interfaces.db.persistence.DocumentAuditRepository;
import com.byterexx.document.correspondence.vo.BaseAdminRequest;
import com.byterexx.document.correspondence.vo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
public class BaseConfigurationService {

    @Autowired
    protected CorrespondenceConfigurationRepository correspondenceConfigurationRepository;

    @Autowired
    protected DocumentAuditRepository auditRepository;

    protected CorrespondenceConfiguration validateClientId(String clientId) {
        Optional<CorrespondenceConfiguration> client = correspondenceConfigurationRepository.findById(clientId);
        if (client.isPresent()) {
            return client.get();
        } else {
            throw new DocumentValidationException(CorrespondenceErrorCode.CLIENT_NOT_FOUND);
        }
    }

    protected void validateDuplicateClientName(String clientName) {
        List<CorrespondenceConfiguration> clients = correspondenceConfigurationRepository.findByClientName(clientName);
        if (!CollectionUtils.isEmpty(clients)) {
            throw new DocumentValidationException(CorrespondenceErrorCode.DUPLICATE_CLIENT_NAME);
        }
    }

    protected void validateDuplicateClientCertName(String clientCertName) {
        List<CorrespondenceConfiguration> clients = correspondenceConfigurationRepository.findByClientCertName(clientCertName);
        if (!CollectionUtils.isEmpty(clients)) {
            throw new DocumentValidationException(CorrespondenceErrorCode.DUPLICATE_CLIENT_CERT_NAME);
        }
    }

    protected void validateDuplicateClientName(String clientId, String clientName) {
        List<CorrespondenceConfiguration> clients = correspondenceConfigurationRepository.findByClientNameAndId(clientName, clientId);
        if (!CollectionUtils.isEmpty(clients)) {
            throw new DocumentValidationException(CorrespondenceErrorCode.DUPLICATE_CLIENT_NAME);
        }
    }

    protected <T extends BaseAdminRequest, K extends BaseResponse> void saveConfigurationAudit(String operation, T request, K response) {
        try {
            DocumentAudit audit = new DocumentAudit();
            audit.setClientId(request.getClientId());
            audit.setRequestId(request.getRequestId());
            audit.setOperationName(operation);
            audit.setResponseCode(response.getResponseCode());
            audit.setResponseDesc(response.getResponseDescription());
            audit.setCreatedBy(request.getUserName());
            audit.setCreatedDate(new Date());
            audit.setRequestPayload(JsonUtil.toJson(request));
            auditRepository.save(audit);
        } catch (Exception e) {
            log.error("Error while saving Correspondence Audit ", e);
        }
    }
}
