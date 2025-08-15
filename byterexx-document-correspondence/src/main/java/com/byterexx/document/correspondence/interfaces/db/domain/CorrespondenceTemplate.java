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
@Table(name = "estatement_correspondence_template")
public class CorrespondenceTemplate {

    @Id
    private String templateId;
    private String templateName;
    private String templateType;
    private String templateContent;
    private String templateImages;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
}
