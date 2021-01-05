package victor.joao.sefaz.service;

import victor.joao.sefaz.controller.request.UsuarioRequest;
import victor.joao.sefaz.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario incluirUsuario(UsuarioRequest usuario);

    boolean login(String email, String senha);

    List<Usuario> buscarTodos();

    Usuario alterarUsuario(Usuario usuario);

    Usuario deletarUsuario(Long id);
}
