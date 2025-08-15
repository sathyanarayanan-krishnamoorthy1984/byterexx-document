package com.byterexx.document.common.exception;

public class DocumentNotFoundException extends DocumentException{

    public DocumentNotFoundException(final DocumentErrorCode errorCode) {
        super(errorCode);
    }

    public DocumentNotFoundException(final String message, final DocumentErrorCode errorCode) {
        super(message, errorCode);
    }

    public DocumentNotFoundException(final String message, final Throwable cause, final DocumentErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public ErrorCode getErrorCode () {
        return this.errorCode;
    }
}
