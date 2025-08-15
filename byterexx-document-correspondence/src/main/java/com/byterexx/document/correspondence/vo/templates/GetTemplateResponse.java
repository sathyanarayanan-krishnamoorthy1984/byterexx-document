package com.byterexx.document.correspondence.vo.templates;

import com.byterexx.document.correspondence.vo.BaseResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.temporal.Temporal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetTemplateResponse extends BaseResponse {
    private List<Template> templates;
}
