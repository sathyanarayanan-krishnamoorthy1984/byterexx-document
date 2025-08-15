package com.byterexx.document.content.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class BaseRequest {
    @JsonIgnore
    @NotBlank(message = "Missing Mandatory Field: {requestId}")
    @Size(max = 36, message = "Invalid Field Length: {requestId}")
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Invalid Field Value: {requestId}")
    private String requestId;

    @JsonIgnore
    @NotEmpty(message = "Missing Mandatory Field: {userName}")
    @Size(max = 64, message = "Invalid Field Length: {userName}")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {userName}")
    private String userName;

    @JsonIgnore
    @NotEmpty(message = "Missing Mandatory Field: {applicationName}")
    @Size(max = 64, message = "Invalid Field Length: {applicationName}")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {applicationName}")
    private String applicationName;
}