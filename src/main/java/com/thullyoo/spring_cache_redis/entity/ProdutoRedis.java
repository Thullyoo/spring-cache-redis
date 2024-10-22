package com.thullyoo.spring_cache_redis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("produto")
public class ProdutoRedis {

    @Id
    @Indexed
    private Long id;

    private String name;

    private Double price;


}
