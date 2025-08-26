package dev.leozinho.mmorpg.character;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
public class CharacterController {


    // Adicionar personagem (CREATE)
    @PostMapping("/create")
    public void createCharacter(){

    }
    // Procurar todos os personagens(READ)
    @GetMapping("/all")
    public void showAllCharacters(){

    }
    // Procurar personagem por id (READ)
    @GetMapping("/showCharacterById")
    public void showCharacterById(){

    }
    // Atualizar personagem (UPDATE)
    @PutMapping("/updateCharacterById")
    public void updateCharacterById(){

    }
    // Deletar personagem (DELETE)
    @DeleteMapping("/deleteCharacterById")
    public void deleteCharacterById(){

    }
}
