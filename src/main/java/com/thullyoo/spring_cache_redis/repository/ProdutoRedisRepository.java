package com.thullyoo.spring_cache_redis.repository;

import com.thullyoo.spring_cache_redis.entity.ProdutoRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRedisRepository extends CrudRepository<ProdutoRedis, Long> {
}
