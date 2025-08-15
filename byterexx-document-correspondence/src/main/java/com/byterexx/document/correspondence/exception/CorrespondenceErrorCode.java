package com.byterexx.document.correspondence.exception;

import com.byterexx.document.common.exception.ErrorCode;

public enum CorrespondenceErrorCode implements ErrorCode {
    INVALID_MIME_TYPE("NOTIFY0001", "Invalid Field Value : {mimeType}",  400),
    DUPLICATE_CLIENT_NAME( "NOTIFY0002",  "Duplicate Client Name",  400),
    DUPLICATE_CLIENT_CERT_NAME( "NOTIFY0003",  "Duplicate Client Certificate Name",  400),
    CLIENT_NOT_FOUND( "NOTIFY0004",  "Client Not Found", 404),
    TEMPLATE_NOT_FOUND( "NOTIFY0005",  "Template Not Found", 404),
    DUPLICATE_TEMPLATE_NAME( "NOTIFY0006", "Duplicate Template Name",  400);

    /**
     * Instantiates a new feds error code.
     *
     * @param responseCode    the error code
     * @param responseMessage the error message
     * @param httpResponseCode the http response code
     */
    private CorrespondenceErrorCode(String responseCode, String responseMessage, int httpResponseCode) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.httpResponseCode = httpResponseCode;
    }

    /**
     * The error code.
     */
    private String responseCode;

    /**
     * The error message.
     */
    private String responseMessage;

    /**
     * The http response code.
     */
    private int httpResponseCode;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * Sets the error message.
     *
     * @param responseMessage the new error message
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    /**
     * Gets the http response code.
     *
     * @return the http response code
     */
    public int getHttpResponseCode() {
        return httpResponseCode;
    }

    /**
     * Sets the http response code.
     *
     * @param httpResponseCode the new http response code
     */
    public void setHttpResponseCode(int httpResponseCode) {
        this.httpResponseCode = httpResponseCode;
    }

    /**
     * To error string.
     *
     * @return the string
     */
    public String toErrorString() { // no usages
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
