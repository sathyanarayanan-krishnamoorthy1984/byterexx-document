package com.byterexx.document.correspondence.vo.configuration;

import com.byterexx.document.correspondence.vo.BaseAdminRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCorrespondenceConfigurationRequest extends BaseAdminRequest {

    @JsonIgnore // no usages
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Invalid Field Value: {requestId}")
    private String clientId;

    @JsonIgnore // no usages
    @Size(max = 64, message = "Invalid Field Length: {clientCertName}")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {clientCertName}")
    private String clientCertName;

    @JsonIgnore // no usages
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Invalid Field Value: {correspondenceId}")
    private String correspondenceId;

    @JsonIgnore // no usages
    @Size(max = 256, message = "Invalid Field Length: {correspondenceName}")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {correspondenceName}")
    private String correspondenceName;
}
