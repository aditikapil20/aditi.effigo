package com.trans_failure.rollback.repository;

import com.trans_failure.rollback.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Long> {
}

