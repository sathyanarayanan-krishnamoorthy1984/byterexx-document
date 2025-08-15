package com.byterexx.document.correspondence.interfaces.voltage;

import com.byterexx.document.common.exception.DocumentErrorCode;
import com.byterexx.document.common.exception.DocumentGenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value = "spring.profiles.active", havingValue = "!local")
public class VoltageCryptoService {

    @Autowired
    private DocProtector docProtector;

    public byte[] encrypt(byte[] plain, String voltageCryptoId) {
        try {
            return docProtector.protect(plain, voltageCryptoId);
        } catch (Exception e) {
            throw new DocumentGenericException(DocumentErrorCode.SYSTEM_ERROR.getResponseMessage(), e, DocumentErrorCode.SYSTEM_ERROR);
        }
    }

    public byte[] decrypt(byte[] cipher, String voltageCryptoId) {
        try {
            return docProtector.access(cipher, voltageCryptoId);
        } catch (Exception e) {
            throw new DocumentGenericException(DocumentErrorCode.SYSTEM_ERROR.getResponseMessage(), e, DocumentErrorCode.SYSTEM_ERROR);
        }
    }
}
