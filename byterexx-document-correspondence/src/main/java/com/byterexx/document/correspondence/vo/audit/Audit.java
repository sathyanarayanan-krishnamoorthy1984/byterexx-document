package com.byterexx.document.correspondence.vo.audit;

import com.byterexx.document.common.converter.DateTimeToConverter;
import com.fasterxml.jackson.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Audit {
    private Long id; // no usages
    private String clientId; // no usages
    private String requestId; // no usages
    private String operationName; // no usages
    private String responseCode; // no usages
    private String responseDesc; // no usages
    private String createdBy; // no usages
    @JsonSerialize(converter = DateTimeToConverter.class) // no usages
    private Date createdDate;
}
