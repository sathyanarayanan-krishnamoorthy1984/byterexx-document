package com.byterexx.document.correspondence.vo.templates;

import com.byterexx.document.common.validator.Base64;
import com.byterexx.document.common.validator.EnumValid;
import com.byterexx.document.correspondence.vo.BaseAdminRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateTemplateRequest extends BaseAdminRequest {
    @NotBlank(message = "Missing Mandatory Field: {templateName}")
    @Size(max = 256, message = "Invalid Field Length: {templateName}")
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Invalid Field Value: {templateName}")
    private String templateName;

    @NotBlank(message = "Missing Mandatory Field: {templateType}")
    @EnumValid(message = "Invalid Field Value: {templateType}", enumClass = TemplateType.class)
    private String templateType;

    @NotBlank(message = "Missing Mandatory Field: {templateContent}")
    @Base64(message = "Invalid Field Value: {templateContent}")
    private String templateContent;

    @NotBlank(message = "Missing Mandatory Field: {templateImages}")
    @Base64(message = "Invalid Field Value: {templateImages}")
    private List<String> templateImages;
}
