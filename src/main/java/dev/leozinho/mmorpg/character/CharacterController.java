package dev.leozinho.mmorpg.character;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> createCharacter(@RequestBody CharacterDTO character){
        CharacterDTO characterDTO = service.createCharacter(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterDTO);
    }
    // Listar todos os personagens(READ)
    @GetMapping("/all")
    public ResponseEntity<?> showAllCharacters(){
        List<CharacterDTO> characters = service.showAllCharacters();
        return  ResponseEntity.ok(characters);
    }
    // Listar personagem por id (READ)
    @GetMapping("/showCharacterById/{id}")
    public ResponseEntity<?> showCharacterById(@PathVariable Long id){
        CharacterDTO character = service.showCharacterById(id);
        if (character != null){
           return ResponseEntity.ok(character);
        }else {
          return   ResponseEntity.status(HttpStatus.NOT_FOUND).body("Character o ID: " + id + " nao foi encontrado");
        }
    }
    // Atualizar personagem (UPDATE)
    @PutMapping("/updateCharacterById/{id}")
    public ResponseEntity<?> updateCharacterById(@PathVariable Long id,@RequestBody CharacterDTO character){
        CharacterDTO characterDTO = service.showCharacterById(id);
        if (characterDTO != null){
          CharacterDTO characteUpdated = service.updateCharacterById(id, character);
         return    ResponseEntity.ok(characteUpdated);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao econtrar o chacater com o ID: " + id);
        }

    }
    // Deletar personagem (DELETE)
    @DeleteMapping("/deleteCharacterById/{id}")
    public ResponseEntity<?> deleteCharacterById(@PathVariable Long id){
       CharacterDTO character = service.showCharacterById(id);
       if (character != null){
           service.deleteCharacterById(id);
         return   ResponseEntity.ok("Character com o ID: " + id + " foi deletado com sucesso");
       }else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Falha ao procurar o Character com o ID: " + id);
       }
    }
}
