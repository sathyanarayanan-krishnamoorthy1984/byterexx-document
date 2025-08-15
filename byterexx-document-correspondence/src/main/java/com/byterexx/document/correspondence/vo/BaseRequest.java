package com.byterexx.document.correspondence.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class BaseRequest {

    @JsonIgnore // no usages
    @NotBlank(message = "Missing Mandatory Field: {requestId}")
    @Size(max = 36, message = "Invalid Field Length: {requestId}")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "Invalid Field Value: {requestId}")
    private String requestId;

    @JsonIgnore // no usages
    @NotEmpty(message = "Missing Mandatory Field: {clientCertName}")
    @Size(max = 64, message = "Invalid Field Length: {clientCertName}")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "Invalid Field Value: {clientCertName}")
    private String clientCertName;

    @JsonIgnore // no usages
    @NotEmpty(message = "Missing Mandatory Field: {applicationName}")
    @Size(max = 64, message = "Invalid Field Length: {applicationName}")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "Invalid Field Value: {applicationName}")
    private String applicationName;
}
