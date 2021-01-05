package victor.joao.sefaz.controller.response;

import lombok.*;
import victor.joao.sefaz.model.Telefone;
import victor.joao.sefaz.model.Usuario;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

    private String nome;

    private String email;

    private String senha;

    private List<Telefone> telefones;
}
