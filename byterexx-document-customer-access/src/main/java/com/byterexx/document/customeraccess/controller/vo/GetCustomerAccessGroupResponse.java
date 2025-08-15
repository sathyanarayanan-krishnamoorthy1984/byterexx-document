package com.byterexx.document.customeraccess.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerAccessGroupResponse extends BaseResponse{
    private List<CustomerAccessGroup> details;
}
