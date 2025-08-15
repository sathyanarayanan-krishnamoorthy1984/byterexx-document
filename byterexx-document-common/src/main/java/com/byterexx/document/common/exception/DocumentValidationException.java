package com.byterexx.document.common.exception;

public class DocumentValidationException extends DocumentException{

    public DocumentValidationException(final ErrorCode errorCode) {
        super(errorCode);
    }

    public DocumentValidationException(final String message, final ErrorCode errorCode) {
        super(message, errorCode);
    }

    public DocumentValidationException(final String message, final Throwable cause, final ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public ErrorCode getErrorCode () {
        return this.errorCode;
    }
}
