package com.byterexx.document.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocumentMetadata {
    private String documentId;
    private String documentType;
    private String documentDate;
    private int totalPages;
    private List<Index> indexes;
}
