package com.byterexx.document.customer.productservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerProductAndServiceRequest extends BaseRequest{
    private String clientId;
    private String productType;
}
