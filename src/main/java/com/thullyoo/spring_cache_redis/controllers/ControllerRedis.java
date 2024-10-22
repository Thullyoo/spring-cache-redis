package com.thullyoo.spring_cache_redis.controllers;

import com.thullyoo.spring_cache_redis.entity.ProdutoRedis;
import com.thullyoo.spring_cache_redis.services.ProdutoRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class ControllerRedis {
    @Autowired
    private ProdutoRedisService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoRedis registrarProdutoRedis(@RequestBody ProdutoRedis produto){
        return produtoService.registrarProduto(produto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoRedis> resgatarProdutosRedis(){
        return produtoService.resgatarProdutos();
    }

}
