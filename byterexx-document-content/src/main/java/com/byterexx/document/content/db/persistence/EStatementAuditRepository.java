package com.byterexx.document.content.db.persistence;

import com.byterexx.document.content.db.domain.EStatementAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EStatementAuditRepository extends JpaRepository<EStatementAudit, Long> {
}
