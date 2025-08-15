package com.byterexx.document.customeraccess.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCustomerAccessRequest extends BaseRequest{
    private String clientId;
    private String userId;
}
