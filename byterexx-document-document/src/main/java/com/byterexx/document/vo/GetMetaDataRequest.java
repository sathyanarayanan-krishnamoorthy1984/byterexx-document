package com.byterexx.document.vo;

import com.byterexx.document.common.validator.DateFormat;
import com.byterexx.document.common.constants.AppConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetMetaDataRequest extends BaseRequest{
    private String folder;
    private List<String> drawers;
    private List<Criteria> criteria;
    @DateFormat(message ="Invalid Field Value : {startDate}", format = AppConstants.DATE_FORMAT_YYYYMMDD)
    private String startDate;
    @DateFormat(message ="Invalid Field Value : {endDate}", format = AppConstants.DATE_FORMAT_YYYYMMDD)
    private String endDate;
}
