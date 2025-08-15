package com.byterexx.document.common.exception;

public class DocumentGenericException extends DocumentException{

    public DocumentGenericException(final DocumentErrorCode errorCode) {
        super(errorCode);
    }

    public DocumentGenericException(final String message, final DocumentErrorCode errorCode) {
        super(message, errorCode);
    }

    public DocumentGenericException (final String message, final Throwable cause,final DocumentErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public ErrorCode getErrorCode () {
        return this.errorCode;
    }
}
