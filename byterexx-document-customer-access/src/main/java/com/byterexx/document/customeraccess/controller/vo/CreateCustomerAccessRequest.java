package com.byterexx.document.customeraccess.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.usertype.UserType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCustomerAccessRequest extends BaseRequest{

    private String clientId;
    private UserType userType;
    private String userId;
    private String emailAddress;
    private String groupId;
    private String securityLevel;
    private UserDetail userDetail;
}
