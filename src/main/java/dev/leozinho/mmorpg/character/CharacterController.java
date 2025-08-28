package dev.leozinho.mmorpg.character;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    // Adicionar personagem (CREATE)
    @PostMapping("/create")
    public CharacterDTO createCharacter(@RequestBody CharacterDTO character){
        return service.createCharacter(character);
    }
    // Listar todos os personagens(READ)
    @GetMapping("/all")
    public List<CharacterDTO> showAllCharacters(){
      return service.showAllCharacters();
    }
    // Listar personagem por id (READ)
    @GetMapping("/showCharacterById/{id}")
    public CharacterDTO showCharacterById(@PathVariable Long id){
      return service.showCharacterById(id);
    }
    // Atualizar personagem (UPDATE)
    @PutMapping("/updateCharacterById/{id}")
    public CharacterDTO updateCharacterById(@PathVariable Long id,@RequestBody CharacterDTO character){
        return service.updateCharacterById(id, character);
    }
    // Deletar personagem (DELETE)
    @DeleteMapping("/deleteCharacterById/{id}")
    public void deleteCharacterById(@PathVariable Long id){
        service.deleteCharacterById(id);
    }
}
