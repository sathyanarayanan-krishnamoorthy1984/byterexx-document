package com.byterexx.document.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Document {
    private String documentId;
    private String mimeType;
    private String content;
}
