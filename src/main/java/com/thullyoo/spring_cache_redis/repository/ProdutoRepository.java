package com.thullyoo.spring_cache_redis.repository;

import com.thullyoo.spring_cache_redis.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
