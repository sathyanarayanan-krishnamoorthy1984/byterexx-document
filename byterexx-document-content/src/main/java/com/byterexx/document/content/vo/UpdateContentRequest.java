package com.byterexx.document.content.vo;


import com.byterexx.document.common.constants.AppConstants;
import com.byterexx.document.common.validator.Base64;
import com.byterexx.document.common.validator.DateFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateContentRequest extends BaseRequest {

    @JsonIgnore
    @Pattern(regexp = "^[a-zA-Z0-9-]*$", message = "Invalid Field Value: {contentId}")
    private String contentId;

    @NotBlank(message = "Missing Mandatory Field: {content}")
    @Base64(message = "Invalid Field Value: {content}")
    private String content;

    @NotBlank(message = "Missing Mandatory Field: {category}")
    private ContentCategory category;

    @NotBlank(message = "Missing Mandatory Field: {mimeType}")
    private String mimeType;

    @DateFormat(message = "Invalid Field Value: {expiry}", format = AppConstants.DATE_FORMAT_YYYYMMDD)
    private String expiry;
}