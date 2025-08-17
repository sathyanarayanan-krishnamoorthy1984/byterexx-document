package com.byterexx.document.controller;


import com.byterexx.document.vo.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Documents")
public class DocumentController {

    @PostMapping("/Metadata/Retrieve")
    public ResponseEntity<GetMetaDataResponse> getMetaData(@RequestHeader(name = "X-Request-Id") String requestId,
                                                           @RequestHeader(name = "X-Auth-Username") String userName,
                                                           @RequestBody GetMetaDataRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        return new ResponseEntity<>(new GetMetaDataResponse(), HttpStatus.OK);
    }

    @GetMapping("/{documentId}")
    public ResponseEntity<GetDocumentResponse> getDocument(@RequestHeader(name = "X-Request-Id") String requestId,
                                                           @RequestHeader(name = "X-Auth-Username") String userName,
                                                           @PathVariable("documentId") String documentId) {
        GetDocumentRequest request = new GetDocumentRequest();
        request.setRequestId(requestId);
        request.setUserName(userName);
        List<String> documentIds = new ArrayList<>();
        documentIds.add(documentId);
        request.setDocumentIds(documentIds);
        return new ResponseEntity<>(new GetDocumentResponse(), HttpStatus.OK);
    }

    @GetMapping("/Retrieve")
    public ResponseEntity<GetDocumentResponse> getDocuments(@RequestHeader(name = "X-Request-Id") String requestId,
                                                            @RequestHeader(name = "X-Auth-Username") String userName,
                                                            @RequestBody GetDocumentRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        return new ResponseEntity<>(new GetDocumentResponse(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BaseResponse> admin(@RequestHeader(name = "X-Request-Id") String requestId,
                                              @RequestHeader(name = "X-Auth-Username") String userName,
                                              @RequestBody DocumentAdminRequest request) {
        request.setRequestId(requestId);
        request.setUserName(userName);
        return new ResponseEntity<>(new BaseResponse(), HttpStatus.OK);
    }
}
