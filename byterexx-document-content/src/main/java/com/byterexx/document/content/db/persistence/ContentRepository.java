package com.byterexx.document.content.db.persistence;

import com.byterexx.document.content.db.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, String> {
    @Query("SELECT cc from Content cc where cc.clientId=:clientId and cc.contentType=:contentType")
    List<Content> findByClientIdAndType(@Param("clientId") String clientId, @Param("contentType") String contentType);
}