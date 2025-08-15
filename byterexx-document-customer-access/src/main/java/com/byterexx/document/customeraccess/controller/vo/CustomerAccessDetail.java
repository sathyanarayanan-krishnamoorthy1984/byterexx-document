package com.byterexx.document.customeraccess.controller.vo;

import com.byterexx.document.common.converter.DateTimeToConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.usertype.UserType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccessDetail {
    private String clientId; 
    private UserType userType;
    private String userId; 
    private String emailAddress; 
    private String userGroup; 
    private String securityLevel; 
    private UserDetail userDetail; 
    private String createdBy; 
    @JsonSerialize(converter = DateTimeToConverter.class)
    private Date createdDate;
    private String updatedBy; 
    @JsonSerialize(converter = DateTimeToConverter.class) 
    private Date updatedDate;
}
