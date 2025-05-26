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
import com.cadastro.util.HashUtil;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AcessoRepository acessoRepository;

    @Override
    public Usuario cadastrarUsuario(UsuarioDTO usuarioDTO) {
        
        if(usuarioRepository.findByEmail(usuarioDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado!");
        }
        String senhaHash = HashUtil.gerarHashSHA256(usuarioDTO.getAcesso().getSenha());

        Usuario usuario = new Usuario(
            usuarioDTO.getNome(),
            usuarioDTO.getEmail(),
            usuarioDTO.getDataNascimento(),
            usuarioDTO.getSexo(),
            usuarioDTO.getCep()
        );

        Acesso acesso = new Acesso(usuario, "USER", senhaHash);
        usuario.setAcesso(acesso);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);    
        acessoRepository.save(acesso);
        return usuarioSalvo;

    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorId(Long id) {
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
