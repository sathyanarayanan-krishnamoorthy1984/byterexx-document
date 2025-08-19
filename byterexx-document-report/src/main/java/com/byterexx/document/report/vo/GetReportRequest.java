package com.byterexx.document.report.vo;

import com.byterexx.document.common.constants.AppConstants;
import com.byterexx.document.common.validator.DateFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetReportRequest extends BaseRequest {

    @NotEmpty(message = "Missing Mandatory Field: {clientId}")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Invalid Field Value: {clientId}")
    private String clientId;

    @NotEmpty(message = "Missing Mandatory Field: {reportType}")
    private ReportType reportType;

    @DateFormat(message = "Invalid Field Value : {startDate}", format = AppConstants.DATE_FORMAT_YYYYMMDD_HHMMSS)
    private String startDate;

    @DateFormat(message = "Invalid Field Value : {endDate}", format = AppConstants.DATE_FORMAT_YYYYMMDD_HHMMSS)
    private String endDate;
}
