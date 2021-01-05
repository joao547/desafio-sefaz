package victor.joao.sefaz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import victor.joao.sefaz.controller.request.LoginRequest;
import victor.joao.sefaz.controller.request.UsuarioRequest;
import victor.joao.sefaz.controller.response.UsuarioResponse;
import victor.joao.sefaz.model.Usuario;
import victor.joao.sefaz.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity salvar(@RequestBody UsuarioRequest usuarioRequest){
        try {
            Usuario usuario = usuarioService.incluirUsuario(usuarioRequest);
            return new ResponseEntity(usuario, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest){
        try {
            boolean isLogged = usuarioService.login(loginRequest.getEmail(), loginRequest.getSenha());
            return new ResponseEntity(isLogged, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity buscarTodos(){
        try {
            List<Usuario> usuarios = usuarioService.buscarTodos();
            return new ResponseEntity(usuarios, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity alterarUsuario(@RequestBody Usuario usuario){
        try {
            Usuario usuarioResponse = usuarioService.alterarUsuario(usuario);
            return new ResponseEntity(usuarioResponse, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarUsuario(@PathVariable("id") Long id){
        try {
            Usuario usuario = usuarioService.deletarUsuario(id);
            return new ResponseEntity(usuario, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
