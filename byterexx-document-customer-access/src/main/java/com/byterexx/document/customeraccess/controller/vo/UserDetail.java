package com.byterexx.document.customeraccess.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDetail {

    private String firstName;
    private String lastName;
    private String name;
    private String personId;
    private String organizationId;
    private String companyName;
    private String companyId;
}
