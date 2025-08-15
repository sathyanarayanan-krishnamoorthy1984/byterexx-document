package com.byterexx.document.common.exception;

public class DocumentServiceUnavailableException extends DocumentException{

    public DocumentServiceUnavailableException(final DocumentErrorCode errorCode) {
        super(errorCode);
    }

    public DocumentServiceUnavailableException(final String message, final DocumentErrorCode errorCode) {
        super(message, errorCode);
    }

    public DocumentServiceUnavailableException(final String message, final Throwable cause, final DocumentErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public ErrorCode getErrorCode () {
        return this.errorCode;
    }
}
