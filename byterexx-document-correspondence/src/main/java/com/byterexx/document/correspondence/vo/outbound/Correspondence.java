package com.byterexx.document.correspondence.vo.outbound;

import com.byterexx.document.common.converter.DateTimeToConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Correspondence {
    private String id; // no usages
    private String batchId; // no usages
    private String content; // no usages
    private String correspondenceType; // no usages
    private String templateId; // no usages
    private Map<String,String> templateVariables; // no usages
    private String status; // no usages
    private String createdBy; // no usages
    @JsonSerialize(converter = DateTimeToConverter.class) // no usages
    private Date createdDate;
    private String updatedBy; // no usages
    @JsonSerialize(converter = DateTimeToConverter.class) // no usages
    private Date updatedDate;
}