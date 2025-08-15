package com.byterexx.document.correspondence.interfaces.db.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "estatement_audit")
public class DocumentAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicationName;
    private String clientId;
    private String requestId;
    private String operationName;
    private String responseCode;
    private String responseDesc;
    private String createdBy;
    private String requestPayload;
    private Date createdDate;
}
