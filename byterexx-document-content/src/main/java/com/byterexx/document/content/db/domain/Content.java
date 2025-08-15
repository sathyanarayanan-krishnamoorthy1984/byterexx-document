package com.byterexx.document.content.db.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "estatement_content")
public class Content {

    @Id
    private String contentId;
    private String contentType;
    private String mimeType;
    @Lob
    private String content;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
}
