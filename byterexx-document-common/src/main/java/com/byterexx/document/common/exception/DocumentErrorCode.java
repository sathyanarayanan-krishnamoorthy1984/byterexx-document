package com.byterexx.document.common.exception;

public enum DocumentErrorCode implements  ErrorCode{

    SUCCESS ("E-STATEMENT0000","Success", 200),
    SYSTEM_ERROR ("E-STATEMENT0001","This is a system error that prevents this action to completed", 500),
    INVALID_FIELD_VALUE ("E-STATEMENT0002","Invalid Field Value", 400),
    MISSING_DELETE_CONFIRM ("E-STATEMENT0005","Missing Mandatory Field : {deleteConfirmation}", 400),
    INVALID_FIELD_TYPE ("E-STATEMENT0003","Invalid Field Type", 400),
    INVALID_FIELD_LENGTH ("E-STATEMENT0004","Invalid Field Length", 400),
    MISSING_MANDATORY_FIELD ("E-STATEMENT0005","Missing Mandatory Field", 400),
    MALFORMED_JSON ("E-STATEMENT0006","Malformed JSON", 400),
    SERVICE_UNAVAILABLE ("E-STATEMENT0007","Service Unavailable", 503),
    UNAUTHORIZED ("E-STATEMENT0008","Unauthorized", 401),
    INCOMPLETE_SETUP ("E-STATEMENT0009","Incomplete Setup. Please work with your administrator to complete the setup", 412),
    DUPLICATE_STORAGE_NAME ("E-STATEMENT0010","Duplicate Storage Name", 400);

    private DocumentErrorCode (String responseCode, String responseMessage, int httpResponseCode) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.httpResponseCode = httpResponseCode;
    }

    private String responseCode;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public int getHttpResponseCode() {
        return httpResponseCode;
    }

    public void setHttpResponseCode(int httpResponseCode) {
        this.httpResponseCode = httpResponseCode;
    }

    private String responseMessage;

    private int httpResponseCode;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String toErrorString () {
        StringBuilder builder = new StringBuilder();
        builder.append("ResponseCode=");
        builder.append(responseCode);
        builder.append(";");
        builder.append("ResponseMessage=");
        builder.append(responseMessage);
        builder.append(";");
        builder.append("HttpResponseCode=");
        builder.append(httpResponseCode);
        builder.append(";");
        return builder.toString();
    }
}
