package com.byterexx.document.correspondence.vo.templates;

import com.byterexx.document.correspondence.vo.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateTemplateResponse extends BaseResponse {

    private String templateId;
}
