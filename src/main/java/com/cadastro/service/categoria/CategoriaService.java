package com.cadastro.service.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.dto.categoria.CategoriaDTO;
import com.cadastro.entity.categoria.Categoria;
import com.cadastro.repository.categoria.CategoriaRepository;

@Service
public class CategoriaService implements CategoriaInterface {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaDTO salvar(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria(
            categoriaDTO.getId(),
            categoriaDTO.getNome(),
            null
        );
        categoria.setId(categoriaRepository.save(categoria).getId());
        categoriaDTO.setId(categoria.getId());
        return categoriaDTO;
    }

    @Override
    public List<Categoria> listarCategoria() {
        
        throw new UnsupportedOperationException("Unimplemented method 'listarCategoria'");
    }

    @Override
    public Optional<Categoria> buscarCategoriaPorId(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'buscarCategoriaPorId'");
    }

    @Override
    public Categoria atualizarCategoria(CategoriaDTO categoriaDTO) {
        
        throw new UnsupportedOperationException("Unimplemented method 'atualizarCategoria'");
    }

    @Override
    public void excluirCategoria(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'excluirCategoria'");
    }
    
}
