package com.byterexx.document.correspondence.service.impl.configuration;

public class BaseConfigurationService {

    @Autowired 10 usages
    protected CorrespondenceConfigurationRepository correspondenceConfigurationRepository;

    protected CorrespondenceConfiguration validateClientId(String clientId) { 2 usages
        Optional<CorrespondenceConfiguration> client = correspondenceConfigurationRepository.findById(clientId);
        if(client.isPresent()) {
            return client.get();
        } else {
            throw new EStatementValidationException(CorrespondenceErrorCode.CLIENT_NOT_FOUND);
        }
    }

    protected void validateDuplicateClientName(String clientName) { 1 usage
        List<CorrespondenceConfiguration> clients = correspondenceConfigurationRepository.findByClientName(clientName);
        if(!CollectionUtils.isEmpty(clients)) {
            throw new EStatementValidationException(CorrespondenceErrorCode.DUPLICATE_CLIENT_NAME);
        }
    }

    protected void validateDuplicateClientCertName(String clientCertName) { 1 usage
        List<CorrespondenceConfiguration> clients = correspondenceConfigurationRepository.findByClientCertName(clientCertName);
        if(!CollectionUtils.isEmpty(clients)) {
            throw new EStatementValidationException(CorrespondenceErrorCode.DUPLICATE_CLIENT_CERT_NAME);
        }
    }

    protected void validateDuplicateClientName(String clientId,String clientName) { 1 usage
        List<CorrespondenceConfiguration> clients = correspondenceConfigurationRepository.findByClientNameAndId(clientName,clientId);
        if(!CollectionUtils.isEmpty(clients)) {
            throw new EStatementValidationException(CorrespondenceErrorCode.DUPLICATE_CLIENT_NAME);
        }
    }

    if(ICollectionUtils.isEmpty(clients)) {
        throw new EStatementValidationException(CorrespondenceErrorCode.DUPLICATE_CLIENT_CERT_NAME);
    }

    protected <T extends BaseAdminRequest, K extends BaseResponse> void saveConfigurationAudit(String operation, T request, K response) {
        try {
            EStatementAudit audit = new EStatementAudit();
            audit.setClientId(request.getClientId());
            audit.setRequestId(request.getRequestId());
            audit.setOperationName(operation);
            audit.setResponseCode(response.getResponseCode());
            audit.setResponseDesc(response.getResponseDescription());
            audit.setCreatedBy(request.getUserName());
            audit.setCreatedDate(new Date());
            audit.setRequestPayload(JsonUtil.toJson(request));
            correspondenceAuditRepository.save(audit);
        } catch (Exception e) {
            log.error("Error while saving Correspondence Audit ", e);
        }
    }
}
