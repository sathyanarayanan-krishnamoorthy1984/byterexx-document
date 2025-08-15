package com.byterexx.document.common.exception;

public class DocumentException extends RuntimeException{

    protected ErrorCode errorCode;

    public DocumentException(final ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public DocumentException (final String message, final ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public DocumentException (final String message, final Throwable cause ,final ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return  this.errorCode;
    }
}
