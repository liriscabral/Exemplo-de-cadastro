package com.cadastro.service.produto;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cadastro.dto.produto.ProdutoDTO;
import com.cadastro.entity.produto.Produto;
import com.cadastro.mapper.ProdutoMapper;
import com.cadastro.repository.produto.ProdutoRepository;

@Service
public class ProdutoService implements ProdutoInterface {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoMapper produtoMapper;

    @Override
    public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
        return produtoMapper.toDto(produtoRepository.save(produtoMapper.toEntity(produtoDTO)));
    }

    @Override
    public List<ProdutoDTO> listarProduto() {
        return produtoRepository.findAll()
                                .stream()
                                .map(produtoMapper::toDto)
                                .collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO buscarProdutoPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                                           .orElseThrow(() -> new RuntimeException("Produto não encontrado com o Id:" + id));
        return produtoMapper.toDto(produto);
    }

    @Override
    public ProdutoDTO atualizarProduto(Long id ,ProdutoDTO produtoDTO) {
        Produto produtoExistente = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id));
        
        produtoExistente.setNome(produtoDTO.getNome());
        produtoExistente.setDescricao(produtoDTO.getDescricao());
        produtoExistente.setPreco(produtoDTO.getPreco());
        produtoExistente.setStatus(produtoDTO.getStatus());

        if (produtoDTO.getCategoria() != null && produtoDTO.getCategoria().getId() != null) {
            produtoExistente.getCategoria().setId(produtoDTO.getCategoria().getId());
        }

        Produto produtoAtualizado = produtoRepository.save(produtoExistente);
        return produtoMapper.toDto(produtoAtualizado);

    }

    @Override
    public void excluirProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com o Id: " + id);
        }
        produtoRepository.deleteById(id);
    }
    
}
