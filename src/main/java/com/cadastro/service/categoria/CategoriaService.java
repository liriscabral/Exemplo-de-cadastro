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
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria atualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if (optionalCategoria.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada com o Id: " + id);
        }

        Categoria categoria = optionalCategoria.get();
        categoria.setId(categoria.getId());
        categoria.setNome(categoriaDTO.getNome());

        return categoriaRepository.save(categoria);
    }

    @Override
    public void excluirCategoria(Long id) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if (optionalCategoria.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada com o Id: " + id);            
        }

        Categoria categoria = optionalCategoria.get();
        categoria.setId(categoria.getId());

        categoriaRepository.delete(categoria);
    }
    
}
