package com.byterexx.document.correspondence.vo.audit;

import com.byterexx.document.common.constants.AppConstants;
import com.byterexx.document.common.validator.DateFormat;
import com.byterexx.document.correspondence.vo.BaseAdminRequest;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 2 usages
@NoArgsConstructor // 1 usage
@Data
public class GetAuditRequest extends BaseAdminRequest {

    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {clientName}") // no usages
    private String clientName;

    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {applicationName}") // no usages
    private String applicationName;

    @Size(max = 16, message = "Invalid Field Length: {clientFiservId}") // no usages
    @Pattern(regexp = "^[0-9]+$", message = "Invalid Field Value: {clientFiservId}")
    private String clientFiservId;

    @DateFormat(message = "Invalid Field Value : {startDate}", format = AppConstants.DATE_FORMAT_YYYYMMDD_HHMMSS) // no usages
    private String startDate;

    @DateFormat(message = "Invalid Field Value : {endDate}", format = AppConstants.DATE_FORMAT_YYYYMMDD_HHMMSS) // no usages
    private String endDate;
}
