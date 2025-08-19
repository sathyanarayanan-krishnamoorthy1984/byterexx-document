package com.byterexx.document.report.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseResponse {

    private String respnseId;
    private String responseCode;
    private String responseDescription;
}
