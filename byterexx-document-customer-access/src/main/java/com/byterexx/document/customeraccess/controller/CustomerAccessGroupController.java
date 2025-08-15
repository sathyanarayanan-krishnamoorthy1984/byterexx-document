package com.byterexx.document.customeraccess.controller;

import com.byterexx.document.common.exception.DocumentErrorCode;
import com.byterexx.document.common.exception.DocumentValidationException;
import com.byterexx.document.customeraccess.controller.vo.*;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CustomerAccessEntitlement/Groups")
@Slf4j
public class CustomerAccessGroupController {
    @PostMapping
    public ResponseEntity<CreateCustomerAccessGroupResponse> create(@RequestHeader(name = "X-Request-Id") String requestId,
                                                                    @RequestHeader(name = "X-Auth-Username") String userName,
                                                                    @RequestBody CreateCustomerAccessGroupRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        return new ResponseEntity<>(new CreateCustomerAccessGroupResponse(), HttpStatus.OK);
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<BaseResponse> update(@RequestHeader(name = "X-Request-Id") String requestId,
                                               @RequestHeader(name = "X-Auth-Username") String userName,
                                               @PathParam("groupId") String groupId,
                                               @RequestBody UpdateCustomerAccessGroupRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        request.setGroupId(groupId);
        return new ResponseEntity<>(new BaseResponse(), HttpStatus.OK);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<BaseResponse> delete(
            @RequestHeader(name = "X-Request-Id") String requestId,
            @RequestHeader(name = "X-Auth-Username") String userName,
            @PathParam("groupId") String groupId,
            @PathVariable("deleteConfirmation") String deleteConfirmation) {
        if (StringUtils.equalsIgnoreCase(deleteConfirmation, "Y")) {
            throw new DocumentValidationException(DocumentErrorCode.MISSING_DELETE_CONFIRM);
        }
        DeleteCustomerAccessGroupRequest request = new DeleteCustomerAccessGroupRequest();
        request.setRequestId(requestId);
        request.setUserName(userName);
        request.setGroupId(groupId);
        return new ResponseEntity<>(new BaseResponse(), HttpStatus.OK);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GetCustomerAccessResponse> get(
            @RequestHeader(name = "X-Request-Id") String requestId,
            @RequestHeader(name = "X-Auth-Username") String userName,
            @PathParam("groupId") String groupId,
            @RequestBody GetCustomerAccessGroupRequest request) {
        request.setGroupId(groupId);
        request.setRequestId(requestId);
        request.setUserName(userName);
        return new ResponseEntity<>(new GetCustomerAccessResponse(), HttpStatus.OK);
    }
}
