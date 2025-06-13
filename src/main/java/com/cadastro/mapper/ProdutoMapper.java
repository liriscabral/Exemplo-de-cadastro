package com.cadastro.mapper;

import org.springframework.stereotype.Component;

import com.cadastro.dto.categoria.CategoriaDTO;
import com.cadastro.dto.produto.ProdutoDTO;
import com.cadastro.entity.categoria.Categoria;
import com.cadastro.entity.produto.Produto;

@Component
public class ProdutoMapper {
    
    public Produto toEntity(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setStatus(dto.getStatus());

        if (dto.getCategoria() != null && dto.getCategoria().getId() != null) {
            Categoria categoria = new Categoria();
            categoria.setId(dto.getCategoria().getId());
            produto.setCategoria(categoria);
        }

        return produto;
    }

    public ProdutoDTO toDto(Produto entity) {
        CategoriaDTO categoriaDTO = null;
    
        if (entity.getCategoria() != null) {
            categoriaDTO = new CategoriaDTO();
            categoriaDTO.setId(entity.getCategoria().getId());
            categoriaDTO.setNome(entity.getCategoria().getNome());
        }
    
        ProdutoDTO dto = new ProdutoDTO(
            entity.getId(),
            entity.getNome(),
            entity.getDescricao(),
            entity.getPreco(),
            entity.getStatus(),
            categoriaDTO
        );
    
        return dto;
    }
    
}
