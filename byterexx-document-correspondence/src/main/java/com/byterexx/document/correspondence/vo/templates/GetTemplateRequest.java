package com.byterexx.document.correspondence.vo.templates;


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
public class GetTemplateRequest extends BaseAdminRequest {

    @JsonIgnore
    @Size(max = 64, message = "Invalid Field Length: {templateId}")
    @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "Invalid Field Value: {templateId}")
    private String templateId;

    @JsonIgnore
    @Size(max = 256, message = "Invalid Field Length: {templateName}")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {templateName}")
    private String templateName;
}
