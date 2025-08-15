package com.byterexx.document.customeraccess.controller.vo;

import com.byterexx.document.common.converter.DateTimeToConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccessGroup {
    private String groupId;
    private String groupName;
    private String parentGroupId;
    private List<String> assignedDrawers;
    private List<String> assignedFolders;
    private Boolean maxSearchableLimit;
    private Boolean maxPrintableLimit;
    private String createdBy;
    @JsonSerialize(converter = DateTimeToConverter.class)
    private Date createdDate;
    private String updatedBy;
    @JsonSerialize(converter = DateTimeToConverter.class)
    private Date updatedDate;
}
