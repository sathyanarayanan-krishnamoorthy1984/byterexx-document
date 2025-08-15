package com.byterexx.document.customeraccess.controller.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateCustomerAccessGroupRequest extends BaseRequest{
    @JsonIgnore
    private String groupId;
    private String groupName;
    private String parentGroupId;
    private List<String> assignedDrawers;
    private List<String> assignedFolders;
    private Boolean maxSearchableLimit;
    private Boolean maxPrintableLimit;

}
