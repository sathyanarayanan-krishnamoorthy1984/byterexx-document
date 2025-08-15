package com.byterexx.document.correspondence.vo.configuration;

import com.byterexx.document.correspondence.vo.BaseAdminRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 2 usages
@NoArgsConstructor // 1 usage
@Data
public class DeleteCorrespondenceConfigurationRequest extends BaseAdminRequest {
    @JsonIgnore
    @NotBlank(message = "Missing Mandatory Field: {configurationId}")
    private String configurationId;
}