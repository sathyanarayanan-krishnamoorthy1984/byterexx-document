package com.byterexx.document.content.controller;

import com.byterexx.document.common.exception.DocumentErrorCode;
import com.byterexx.document.common.exception.DocumentValidationException;
import com.byterexx.document.content.service.ContentService;
import com.byterexx.document.content.service.ContentServiceFactory;
import com.byterexx.document.content.vo.*;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Content")
@Slf4j
public class ContentController {

    @Autowired
    private ContentServiceFactory contentServiceFactory;

    @PostMapping
    public ResponseEntity<CreateContentResponse> create(@RequestHeader(name = "X-Request-Id") String requestId,
                                                        @RequestHeader(name = "X-Auth-Username") String userName,
                                                        @RequestBody CreateContentRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        CreateContentResponse response = contentServiceFactory.service(ContentService.CREATE_CONTENT, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GetContentResponse> getByClientId(@RequestHeader(name = "X-Request-Id") String requestId,
                                                            @RequestHeader(name = "X-Auth-Username") String userName,
                                                            @PathParam("clientId") String clientId) {
        GetContentRequest request = new GetContentRequest();
        request.setRequestId(requestId);
        request.setClientId(clientId);
        request.setUserName(userName);
        GetContentResponse response = contentServiceFactory.service(ContentService.GET_CONTENT, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/Clients/{clientId}/Categories/{category}")
    public ResponseEntity<GetContentResponse> getByCertName(@RequestHeader(name = "X-Request-Id") String requestId,
                                                            @RequestHeader(name = "X-Auth-Username") String userName,
                                                            @PathParam("type") ContentCategory category,
                                                            @PathParam("clientId") String clientId) {
        GetContentRequest request = new GetContentRequest();
        request.setRequestId(requestId);
        request.setContentCategory(category);
        request.setUserName(userName);
        GetContentResponse response = contentServiceFactory.service(ContentService.GET_CONTENT, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<GetContentResponse> getById(@RequestHeader(name = "X-Request-Id") String requestId,
                                                      @RequestHeader(name = "X-Auth-Username") String userName,
                                                      @PathParam("contentId") String contentId) {
        GetContentRequest request = new GetContentRequest();
        request.setRequestId(requestId);
        request.setContentId(contentId);
        request.setUserName(userName);
        GetContentResponse response = contentServiceFactory.service(ContentService.GET_CONTENT, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{contentId}")
    public ResponseEntity<BaseResponse> update(@RequestHeader(name = "X-Request-Id") String requestId,
                                               @RequestHeader(name = "X-Auth-Username") String userName,
                                               @PathParam("contentId") String contentId,
                                               @RequestBody UpdateContentRequest request) {
        request.setRequestId(requestId);
        request.setContentId(contentId);
        request.setUserName(userName);
        BaseResponse response = contentServiceFactory.service(ContentService.UPDATE_CONTENT, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{contentId}")
    public ResponseEntity<BaseResponse> delete(@RequestHeader(name = "X-Request-Id") String requestId,
                                               @RequestHeader(name = "X-Auth-Username") String userName,
                                               @PathParam("contentId") String contentId,
                                               @PathVariable("deleteConfirmation") String deleteConfirmation) {
        if (StringUtils.equalsIgnoreCase(deleteConfirmation, "Y")) {
            throw new DocumentValidationException(DocumentErrorCode.MISSING_DELETE_CONFIRM);
        }
        DeleteContentRequest request = new DeleteContentRequest();
        request.setContentId(contentId);
        request.setUserName(userName);
        BaseResponse response = contentServiceFactory.service(ContentService.UPDATE_CONTENT, request, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
