package com.byterexx.document.correspondence.vo.configuration;

import com.byterexx.document.common.validator.EnumValid;
import com.byterexx.document.common.validator.LocaleValid;
import com.byterexx.document.correspondence.vo.BaseAdminRequest;
import com.byterexx.document.correspondence.vo.CorrespondenceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateCorrespondenceConfigurationRequest extends BaseAdminRequest {
    @NotBlank(message = "Missing Mandatory Field: {correspondenceName}")
    @Size(max = 256, message = "Invalid Field Length: {correspondenceName}")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {correspondenceName}")
    private String correspondenceName;

    @NotBlank(message = "Missing Mandatory Field: {clientId}")
    @Size(max = 64, message = "Invalid Field Length: {clientId}")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {clientId}")
    private String clientId;

    @NotBlank(message = "Missing Mandatory Field: {clientName}")
    @Size(max = 256, message = "Invalid Field Length: {clientName}")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {clientName}")
    private String clientName;

    @NotEmpty(message = "Missing Mandatory Field: {clientCertName}")
    @Size(max = 256, message = "Invalid Field Length: {clientCertName}")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {clientCertName}")
    private String clientCertName;

    @NotEmpty(message = "Missing Mandatory Field: {fiservId}")
    @Size(max = 16, message = "Invalid Field Length: {fiservId}")
    @Pattern(regexp = "^[0-9]*$", message = "Invalid Field Value: {fiservId}")
    private String fiservId;

    @Size(max = 4, message = "Invalid Field Length: {billingSystem}")
    @Pattern(regexp = "^[0-9]*$", message = "Invalid Field Value: {billingSystem}")
    private String billingSystem;

    @Size(max = 4, message = "Invalid Field Length: {billingPrincipal}")
    @Pattern(regexp = "^[0-9]*$", message = "Invalid Field Value: {billingPrincipal}")
    private String billingPrincipal;

    private boolean correspondencePrecomposed;

    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {templateId}")
    private String templateId;

    @EnumValid(message = "Invalid Field Value: {correspondenceType}", enumClass = CorrespondenceType.class)
    private String correspondenceType;

    @EnumValid(message = "Invalid Field Value: {correspondenceServiceProvider}", enumClass = CorrespondenceServiceProvider.class)
    private String correspondenceServiceProvider;

    @LocaleValid(message = "Invalid Field Value: {correspondenceLocale}", enumClass = CorrespondenceServiceProvider.class)
    private String correspondenceLocale;
}
