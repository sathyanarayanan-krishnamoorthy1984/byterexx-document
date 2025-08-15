package com.byterexx.document.correspondence.vo.configuration;

import com.byterexx.document.common.converter.DateTimeToConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CorrespondenceConfiguration {
    private String correspondenceId; // no usages
    private String correspondenceName; // no usages
    private String correspondenceType; // no usages
    private String correspondenceServiceProvider; // no usages
    private String correspondenceLocale; // no usages
    private String clientId; // no usages
    private String clientName; // no usages
    private String clientCertName; // no usages
    private String fiservId; // no usages
    private String billingSystem; // no usages
    private String billingPrincipal; // no usages
    private String templateId; // no usages
    private String createdBy; // no usages
    @JsonSerialize(converter = DateTimeToConverter.class) // no usages
    private Date createdDate;
    private String updatedBy; // no usages

}