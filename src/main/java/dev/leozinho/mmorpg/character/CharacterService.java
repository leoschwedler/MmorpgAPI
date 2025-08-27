package dev.leozinho.mmorpg.character;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    private CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    // Adicionar personagem (CREATE)
    public CharacterEntity createCharacter(CharacterEntity character){
       return repository.save(character);
    }

    // Listar todos os personagens (READ)
    public List<CharacterEntity> showAllCharacters(){
        return repository.findAll();
    }

    // Listar personagem por id (READ)
    public CharacterEntity showCharacterById(Long id){
         Optional<CharacterEntity> characterById = repository.findById(id);
         return characterById.orElse(null);
    }

    // Atualizar personagem (UPDATE)
    public CharacterEntity updateCharacterById(Long id, CharacterEntity character){
        if (repository.existsById(id)) {
          character.setId(id);
          return repository.save(character);
        }else {
          return  null;
        }
    }

    // Deletar personagem (DELETE)
    public void deleteCharacterById(Long id){
         repository.deleteById(id);
    }
}
