package com.byterexx.document.content.vo;


import com.byterexx.document.common.constants.AppConstants;
import com.byterexx.document.common.validator.Base64;
import com.byterexx.document.common.validator.DateFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateContentRequest extends BaseRequest {

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