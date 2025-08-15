package com.byterexx.document.common.exception;

public class DocumentTimeoutException extends DocumentException{

    public DocumentTimeoutException(final DocumentErrorCode errorCode) {
        super(errorCode);
    }

    public DocumentTimeoutException(final String message, final DocumentErrorCode errorCode) {
        super(message, errorCode);
    }

    public DocumentTimeoutException(final String message, final Throwable cause, final DocumentErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public ErrorCode getErrorCode () {
        return this.errorCode;
    }
}
