package com.byterexx.document.correspondence.vo.templates;

import com.byterexx.document.common.converter.DateTimeToConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Template {
    private String templateName; // no usages
    private String templateType; // no usages
    private String templateContent; // no usages
    private List<String> templateImages; // no usages
    private String createdBy; // no usages
    @JsonSerialize(converter = DateTimeToConverter.class) // no usages
    private Date createdDate;
    private String updatedBy; // no usages
    @JsonSerialize(converter = DateTimeToConverter.class) // no usages
    private Date updatedDate;
}
