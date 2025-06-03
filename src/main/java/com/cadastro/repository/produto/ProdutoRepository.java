package com.cadastro.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cadastro.entity.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
