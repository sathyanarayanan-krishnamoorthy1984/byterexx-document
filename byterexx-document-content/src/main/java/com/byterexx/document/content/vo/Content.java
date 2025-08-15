package com.byterexx.document.content.vo;

import com.byterexx.document.common.converter.DateTimeToConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class Content {
    private String content;
    private ContentCategory category;
    private String mimeType;
    private String expiry;
    private String createdBy;
    @JsonSerialize(converter = DateTimeToConverter.class)
    private Date createdDate;
    private String updatedBy;
    @JsonSerialize(converter = DateTimeToConverter.class)
    private Date updatedDate;
}
