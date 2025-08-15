package com.byterexx.document.correspondence.vo.outbound;

import com.byterexx.document.common.validator.Base64;
import com.byterexx.document.common.validator.EnumValid;
import com.byterexx.document.correspondence.vo.BaseRequest;
import com.byterexx.document.correspondence.vo.CorrespondenceType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCorrespondenceRequest extends BaseRequest {
    @JsonIgnore
    @NotBlank(message = "Missing Mandatory Field: {id}")
    @Size(max = 64, message = "Invalid Field Length: {id}")
    @Pattern(regexp = "^[a-zA-Z0-9-_]*$", message = "Invalid Field Value: {id}")
    private String id;

    @NotBlank(message = "Missing Mandatory Field: {batchId}")
    @Size(max = 64, message = "Invalid Field Length: {batchId}")
    @Pattern(regexp = "^[a-zA-Z0-9-_]*$", message = "Invalid Field Value: {batchId}")
    private String batchId;

    @Base64(message = "Invalid Field Value: {content}")
    private String content;

    @EnumValid(message = "Invalid Field Value: {correspondenceType}", enumClass = CorrespondenceType.class)
    private String correspondenceType;

    @Size(max = 64, message = "Invalid Field Length: {templateId}")
    @Pattern(regexp = "^[a-zA-Z0-9-_]*$", message = "Invalid Field Value: {templateId}")
    private String templateId;

    private Map<@Size(max = 64, message = "Invalid Field Length: {templateVariableName}")
        @Pattern(regexp = "^[a-zA-Z0-9-_]*$", message = "Invalid Field Value: {templateVariableName}") String,
                @Size(max = 64, message = "Invalid Field Length: {templateVariableValue}")
                @Pattern(regexp = "^[a-zA-Z0-9-_]*$", message = "Invalid Field Value: {templateVariableValue}") String> templateVariables;

    private Map<@Size(max = 256, message = "Invalid Field Length: {attachmentName}")
    @Pattern(regexp = "^[a-zA-Z0-9-_]*$", message = "Invalid Field Value: {attachmentName}") String,
            @Base64(message = "Invalid Field Value: {attachmentContent}") String> attachments;
}