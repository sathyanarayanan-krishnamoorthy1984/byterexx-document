package com.byterexx.document.security.util;

import com.byterexx.document.common.exception.DocumentAuthorizationException;
import com.byterexx.document.common.exception.DocumentErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;


public class SecurityUtil {

        public static void getUser() {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            if (securityContext != null) {
                Neo4jProperties.Authentication authentication = securityContext.getAuthentication();
                if (authentication != null) {
                    processPrincipal(authentication.getPrincipal());
                }
            } else {
                throw new DocumentAuthorizationException(DocumentErrorCode.UNAUTHORIZED);
            }
        }

        private static String processPrincipal(Object principal) {
            String username = null;
            if (principal != null) {
                if (principal instanceof UserDetails) {
                    username = ((UserDetails) principal).getUsername();
                } else if (principal instanceof OAuth2ResourceServerProperties.Jwt) {
                    OAuth2ResourceServerProperties.Jwt jwt = (OAuth2ResourceServerProperties.Jwt) principal;
                    username = (String) jwt.getClaims().get("preferred_username");
                }
            }
            if (StringUtils.isBlank(username)) {
                throw new DocumentAuthorizationException(DocumentErrorCode.UNAUTHORIZED);
            }
            return username;
        }
}

