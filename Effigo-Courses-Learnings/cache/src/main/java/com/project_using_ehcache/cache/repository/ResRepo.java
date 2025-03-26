package com.project_using_ehcache.cache.repository;

import com.project_using_ehcache.cache.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResRepo extends JpaRepository<Restaurant, Long> {
}
