package com.redis.spring_data_redis_cache.repository;

import com.redis.spring_data_redis_cache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
