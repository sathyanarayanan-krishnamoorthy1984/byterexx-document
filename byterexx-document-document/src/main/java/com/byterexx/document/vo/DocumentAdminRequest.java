package com.byterexx.document.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocumentAdminRequest extends BaseRequest{
    private String folder;
    private List<String> drawers;
    private IDType idType;
    private List<String> ids;
    private Operation operation;
    private String comment;
}
