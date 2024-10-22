package com.thullyoo.spring_cache_redis.services;

import com.thullyoo.spring_cache_redis.entity.Produto;
import com.thullyoo.spring_cache_redis.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto registrarProduto(Produto produto){
        System.out.println(produto);
        return produtoRepository.save(produto);
    }

    public List<Produto> resgatarProdutos(){
        return produtoRepository.findAll();
    }

    public void salvaTudo(List<Produto> produtos) {
        produtos.forEach(produto -> {
            produtoRepository.save(produto);
        });
    }
}
