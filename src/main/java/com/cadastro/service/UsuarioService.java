package com.cadastro.service;

import java.util.List;
import java.util.Optional;

import com.cadastro.dto.UsuarioDTO;
import com.cadastro.entity.Usuario;

public interface UsuarioService {
    
    //salvar usuario
    Usuario cadastrarUsuario(UsuarioDTO usuarioDTO);

    //listar usuario
    List<Usuario> listarUsuarios();

    //buscar por id
    Optional<Usuario> buscarUsuarioPorId(Long id);

    //atualizar usuario
    Usuario atualizarUsuario(Long id, UsuarioDTO usuarioDTO);

    //remover usuario
    void deletarUsuario(Long id);
}
