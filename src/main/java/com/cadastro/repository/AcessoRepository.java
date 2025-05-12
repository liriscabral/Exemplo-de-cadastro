package com.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.Entity.Acesso;

public interface AcessoRepository extends JpaRepository<Acesso, Long> {
    
}
