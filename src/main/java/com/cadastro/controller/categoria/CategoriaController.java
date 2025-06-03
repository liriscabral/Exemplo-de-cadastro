package com.cadastro.controller.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.dto.categoria.CategoriaDTO;
import com.cadastro.service.categoria.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDTO> salvarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok(categoriaService.salvar(categoriaDTO));
    }

}
