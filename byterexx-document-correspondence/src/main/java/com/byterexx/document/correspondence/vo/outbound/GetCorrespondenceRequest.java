package com.byterexx.document.correspondence.vo.outbound;

import com.byterexx.document.correspondence.vo.BaseRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCorrespondenceRequest extends BaseRequest {

    @JsonIgnore
    @Size(max = 64, message = "Invalid Field Length: {templateId}")
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Invalid Field Value: {templateId}")
    private String id;

    @JsonIgnore
    @Size(max = 64, message = "Invalid Field Length: {batchId}")
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Invalid Field Value: {batchId}")
    private String batchId;
}