package com.byterexx.document.correspondence.interfaces.db.persistence;

import com.byterexx.document.correspondence.interfaces.db.domain.DocumentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentAuditRepository extends JpaRepository<DocumentAudit, Long> {
}
