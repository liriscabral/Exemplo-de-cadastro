package com.cadastro.service.produto;

import java.util.List;
import com.cadastro.dto.produto.ProdutoDTO; 

public interface ProdutoInterface {

    ProdutoDTO salvar(ProdutoDTO produtoDTO);

    List<ProdutoDTO> listarProduto();

    ProdutoDTO buscarProdutoPorId(Long id);

    ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO);

    void excluirProduto(Long id);

}
