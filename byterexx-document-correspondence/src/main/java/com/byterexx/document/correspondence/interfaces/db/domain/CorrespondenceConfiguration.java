package com.byterexx.document.correspondence.interfaces.db.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "estatement_correspondence_config")
public class CorrespondenceConfiguration {

    @Id
    private String configurationId;
    private String correspondenceType;
    private String correspondenceServiceProvider;
    private String correspondenceLocale;
    private String correspondenceName;
    private String clientID;
    private String clientName;
    private String clientCertName;
    private String fiservId;
    private String billingSystem;
    private String billingPrincipal;
    private String templateId;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
}
