package com.cadastro.dto.produto;

import com.cadastro.dto.categoria.CategoriaDTO;
import com.cadastro.enums.StatusProduto;

public class ProdutoDTO {
    
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private StatusProduto status;
    private CategoriaDTO categoria;

    public ProdutoDTO() {}    
    public ProdutoDTO(Long id, String nome, String descricao, Double preco, StatusProduto status,
            CategoriaDTO categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public StatusProduto getStatus() {
        return status;
    }
    public void setStatus(StatusProduto status) {
        this.status = status;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

}