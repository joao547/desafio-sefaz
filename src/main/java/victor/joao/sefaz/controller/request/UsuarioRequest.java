package victor.joao.sefaz.controller.request;

import lombok.*;
import victor.joao.sefaz.model.Telefone;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    private String nome;

    private String email;

    private String senha;

    private List<Telefone> telefones;
}
