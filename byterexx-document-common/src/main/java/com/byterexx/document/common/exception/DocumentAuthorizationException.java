package com.byterexx.document.common.exception;

public class DocumentAuthorizationException extends DocumentException{

    public DocumentAuthorizationException(final DocumentErrorCode errorCode) {
        super(errorCode);
    }

    public DocumentAuthorizationException(final String message, final DocumentErrorCode errorCode) {
        super(message, errorCode);
    }

    public DocumentAuthorizationException(final String message, final Throwable cause, final DocumentErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public ErrorCode getErrorCode () {
        return this.errorCode;
    }
}
