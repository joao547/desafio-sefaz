package victor.joao.sefaz.service.impl;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import victor.joao.sefaz.controller.request.UsuarioRequest;
import victor.joao.sefaz.controller.response.UsuarioResponse;
import victor.joao.sefaz.model.Usuario;
import victor.joao.sefaz.repository.UsuarioRepository;
import victor.joao.sefaz.service.UsuarioService;

import java.util.HashSet;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario incluirUsuario(UsuarioRequest usuario) {
        Usuario usuarioPersistent = Usuario.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt()))
                .telefones(new HashSet<>(usuario.getTelefones())).build();
        usuarioPersistent = usuarioRepository.save(usuarioPersistent);
        return usuarioPersistent;
    }

    @Override
    public boolean login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return BCrypt.checkpw(senha, usuario.getSenha());
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario alterarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.deleteById(id);
        return usuario;
    }
}
