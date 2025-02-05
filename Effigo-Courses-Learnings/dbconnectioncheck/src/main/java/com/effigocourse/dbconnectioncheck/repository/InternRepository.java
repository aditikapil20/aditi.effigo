package com.effigocourse.dbconnectioncheck.repository;

import com.effigocourse.dbconnectioncheck.entity.InternEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends JpaRepository<InternEntity, Integer> {

}
