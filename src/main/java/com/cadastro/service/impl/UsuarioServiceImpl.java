package com.cadastro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.Entity.Acesso;
import com.cadastro.Entity.Usuario;
import com.cadastro.dto.UsuarioDTO;
import com.cadastro.repository.AcessoRepository;
import com.cadastro.repository.UsuarioRepository;
import com.cadastro.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AcessoRepository acessoRepository;

    @Override
    public Usuario cadastrarUsuario(UsuarioDTO usuarioDTO) {
        
        Usuario usuario = new Usuario(
            usuarioDTO.getNome(),
            usuarioDTO.getEmail(),
            usuarioDTO.getDataNascimento(),
            usuarioDTO.getSexo(),
            usuarioDTO.getCep()
        );

        Acesso acesso = new Acesso("USER", "senha123");
        usuario.setAcesso(acesso);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);    
        acessoRepository.save(acesso);

        return usuarioSalvo;

    }

    @Override
    public List<Usuario> listaUsuarios() {
        throw new UnsupportedOperationException("Unimplemented method 'listaUsuarios'");
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Usuario atualizUsuario(Long id, UsuarioDTO usuarioDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'atualizUsuario'");
    }

    @Override
    public void deletarUsuario(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deletarUsuario'");
    }
    
}
