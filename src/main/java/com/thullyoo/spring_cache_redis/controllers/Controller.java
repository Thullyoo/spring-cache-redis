package com.thullyoo.spring_cache_redis.controllers;

import com.thullyoo.spring_cache_redis.entity.Produto;
import com.thullyoo.spring_cache_redis.entity.ProdutoRedis;
import com.thullyoo.spring_cache_redis.services.ProdutoRedisService;
import com.thullyoo.spring_cache_redis.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class Controller {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto registrarProduto(@RequestBody Produto produto){
        return produtoService.registrarProduto(produto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> resgatarProdutos(){
        return produtoService.resgatarProdutos();
    }

}
