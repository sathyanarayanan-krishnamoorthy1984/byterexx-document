package com.byterexx.document.content.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetContentResponse extends BaseResponse{

    private List<Content> contents;
}
