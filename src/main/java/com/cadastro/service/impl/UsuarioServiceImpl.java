package com.cadastro.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.dto.UsuarioDTO;
import com.cadastro.entity.Acesso;
import com.cadastro.entity.Usuario;
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
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario atualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isEmpty()) {
            throw new RuntimeException("Usuario não encontrado com o Id: " + id);
        }

        Usuario usuario = optionalUsuario.get();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        usuario.setSexo(usuarioDTO.getSexo());
        usuario.setCep(usuarioDTO.getCep());

        return usuarioRepository.save(usuario);
    }

    @Override
    public void deletarUsuario(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            if (usuario.getAcesso() != null) {
                acessoRepository.delete(usuario.getAcesso());
            }
            usuarioRepository.delete(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado com o Id: " + id);
        }
    }
    
}
