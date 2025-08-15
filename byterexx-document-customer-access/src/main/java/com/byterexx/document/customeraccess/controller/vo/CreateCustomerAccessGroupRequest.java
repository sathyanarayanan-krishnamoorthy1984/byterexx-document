package com.byterexx.document.customeraccess.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCustomerAccessGroupRequest extends BaseRequest{

    private String groupName;
    private String parentGroupId;
    private List<String> assignedDrawers;
    private List<String> assignedFolders;
    private Boolean maxSearchableLimit;
    private Boolean maxPrintableLimit;

}
