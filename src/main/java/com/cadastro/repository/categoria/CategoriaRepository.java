package com.cadastro.repository.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cadastro.entity.categoria.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
