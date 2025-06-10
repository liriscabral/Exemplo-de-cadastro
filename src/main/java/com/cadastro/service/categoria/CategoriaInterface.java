package com.cadastro.service.categoria;

import java.util.List;
import java.util.Optional;

import com.cadastro.dto.categoria.CategoriaDTO;
import com.cadastro.entity.categoria.Categoria;

public interface CategoriaInterface {
    
    CategoriaDTO salvar(CategoriaDTO categoriaDTO);

    List<Categoria> listarCategoria();

    Optional<Categoria> buscarCategoriaPorId(Long id);

    Categoria atualizarCategoria(Long id, CategoriaDTO categoriaDTO);

    void excluirCategoria(Long id);

}
