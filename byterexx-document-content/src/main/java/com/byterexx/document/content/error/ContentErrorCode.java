package com.byterexx.document.content.error;

import com.byterexx.document.common.exception.ErrorCode;

public enum ContentErrorCode implements ErrorCode {
    INVALID_MIME_TYPE("CONTENT0001", "Invalid Field Value : {mimeType}", 400);

    /**
     * Instantiates a new feds error code.
     *
     * @param responseCode    the error code
     * @param responseMessage the error message
     * @param httpResponseCode the http response code
     */
    private ContentErrorCode(String responseCode, String responseMessage, int httpResponseCode) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.httpResponseCode = httpResponseCode;
    }

    /**
     * The error code.
     */
    private String responseCode; // 4 usages

    /**
     * The error message.
     */
    private String responseMessage; // 4 usages

    /**
     * The http response code.
     */
    private int httpResponseCode; // 4 usages

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

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

    public String toErrorString() {
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
