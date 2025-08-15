package com.byterexx.document.content.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetContentRequest extends BaseRequest {

    @JsonIgnore
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Invalid Field Value: {contentId}")
    private String contentId;

    @JsonIgnore
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Invalid Field Value: {clientId}")
    private String clientId;

    @JsonIgnore
    private ContentCategory contentCategory;
}
