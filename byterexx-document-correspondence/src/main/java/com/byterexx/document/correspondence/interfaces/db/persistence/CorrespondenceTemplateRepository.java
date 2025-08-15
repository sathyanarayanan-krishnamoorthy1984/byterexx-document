package com.byterexx.document.correspondence.interfaces.db.persistence;

import com.byterexx.document.correspondence.interfaces.db.domain.CorrespondenceTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CorrespondenceTemplateRepository extends JpaRepository<CorrespondenceTemplate, String> {

    @Query("SELECT ct from CorrespondenceTemplate ct where ct.templateName=:templateName")
    List<CorrespondenceTemplate> findByTemplateName(@Param("templateName") String templateName);

    @Query("SELECT ct from CorrespondenceTemplate ct where ct.templateName=:templateName and ct.templateId=:templateId")
    List<CorrespondenceTemplate> findByTemplateNameAndId(@Param("templateName") String templateName, @Param("templateId") String templateId);
}
