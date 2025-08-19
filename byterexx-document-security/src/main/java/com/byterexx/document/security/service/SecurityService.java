package com.byterexx.document.security.service;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

public interface SecurityService {
    public SecurityProperties.User authenticate (String userName, String password);
}
