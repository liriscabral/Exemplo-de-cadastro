package com.cadastro.service.produto;

import java.util.List;
import java.util.Optional;

import com.cadastro.dto.produto.ProdutoDTO;
import com.cadastro.entity.produto.Produto;

public interface PodutoInterface {

    ProdutoDTO salvar(ProdutoDTO produtoDTO);

    List<Produto> listarProduto();

    Optional<Produto> buscarProdutoPorId(Long id);

    Produto atualizarProduto(ProdutoDTO produtoDTO);

    void excluirProduto(Long id);

}
