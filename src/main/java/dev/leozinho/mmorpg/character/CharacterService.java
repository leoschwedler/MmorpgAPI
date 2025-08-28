package dev.leozinho.mmorpg.character;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    private final CharacterRepository repository;
    private final CharacterMapper characterMapper;

    public CharacterService(CharacterRepository repository, CharacterMapper characterMapper) {
        this.repository = repository;
        this.characterMapper = characterMapper;
    }

    // Adicionar personagem (CREATE)
    public CharacterDTO createCharacter(CharacterDTO characterDTO){
        CharacterEntity character = characterMapper.map(characterDTO);
        character = repository.save(character);
        return characterMapper.map(character);
    }

    // Listar todos os personagens (READ)
    public List<CharacterDTO> showAllCharacters(){
        List<CharacterEntity> character = repository.findAll();
        return character.stream()
                .map(characterMapper::map)
                .collect(Collectors.toList());
    }

    // Listar personagem por id (READ)
    public CharacterDTO showCharacterById(Long id){
         Optional<CharacterEntity> character = repository.findById(id);
        return character.map(characterMapper::map).orElse(null);
    }

    // Atualizar personagem (UPDATE)
    public CharacterDTO updateCharacterById(Long id, CharacterDTO characterDTO){
        Optional<CharacterEntity> character = repository.findById(id);
        if (character.isPresent()){
            CharacterEntity characterExist = characterMapper.map(characterDTO);
            characterExist.setId(id);
            CharacterEntity characterSaved = repository.save(characterExist);
            return characterMapper.map(characterSaved);
        }
        return null;
    }

    // Deletar personagem (DELETE)
    public void deleteCharacterById(Long id){
         repository.deleteById(id);
    }
}
