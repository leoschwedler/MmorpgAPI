package dev.leozinho.mmorpg.character;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @GetMapping("/boas_vindas")
    public String boasVindas(){
        return "bem vindo a sua primeira rota viado";
    }
}
