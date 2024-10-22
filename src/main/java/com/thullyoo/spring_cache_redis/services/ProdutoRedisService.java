package com.thullyoo.spring_cache_redis.services;

import com.thullyoo.spring_cache_redis.entity.Produto;
import com.thullyoo.spring_cache_redis.entity.ProdutoRedis;
import com.thullyoo.spring_cache_redis.repository.ProdutoRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
@Slf4j
public class ProdutoRedisService {

    private static final int MINUTO = 1000 * 60;
    private static final long MINUTOS = MINUTO * 2;

    @Autowired
    private ProdutoRedisRepository produtoRedisRepository;

    @Autowired
    private ProdutoService produtoService;

    public ProdutoRedis registrarProduto(ProdutoRedis produto){
        return produtoRedisRepository.save(produto);
    }

    public List<ProdutoRedis> resgatarProdutos(){
        return (List<ProdutoRedis>) produtoRedisRepository.findAll();
    }

    public void deletaTudo(List<ProdutoRedis> produtoRedis){
        produtoRedisRepository.deleteAll();
    }

    @Scheduled(fixedDelay = MINUTOS)
    public void sincronizarH2comRedis(){
        List<ProdutoRedis> produtosRedis = resgatarProdutos();
        if (produtosRedis.isEmpty()){
            log.info("Redis vazio");
        } else {
            List<Produto> produtos = new ArrayList<>();
            produtosRedis.stream()
                    .forEach((produtoRedis) ->{
                        Produto produto = new Produto();
                        BeanUtils.copyProperties(produtoRedis, produto);
                        produtos.add(produto);
                    });
            produtoService.salvaTudo(produtos);
            deletaTudo(produtosRedis);
        }
    }
}
