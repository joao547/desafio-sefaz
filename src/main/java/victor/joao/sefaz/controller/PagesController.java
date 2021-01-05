package victor.joao.sefaz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    private UsuarioController usuarioController;

    public PagesController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    @GetMapping({"/", "/login"})
    public String loginTela(Model model){
        return "login";
    }

    @GetMapping("/usuarios")
    public String usuariosTela(Model model){
        model.addAttribute("usuarios", usuarioController.buscarTodos().getBody());
        return "usuarios";
    }
}
