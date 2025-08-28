package dev.leozinho.mmorpg.character;

import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {

    public CharacterEntity map(CharacterDTO characterDTO){
      CharacterEntity characterEntity = new CharacterEntity();
      characterEntity.setId(characterDTO.getId());
      characterEntity.setName(characterDTO.getName());
      characterEntity.setLevel(characterDTO.getLevel());
      characterEntity.setCharacterClass(characterDTO.getCharacterClass());
      characterEntity.setGuild(characterDTO.getGuild());
      characterEntity.setItems(characterDTO.getItems());
      return characterEntity;
    };

    public CharacterDTO map(CharacterEntity characterEntity){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(characterEntity.getId());
        characterDTO.setName(characterEntity.getName());
        characterDTO.setLevel(characterEntity.getLevel());
        characterDTO.setCharacterClass(characterEntity.getCharacterClass());
        characterDTO.setGuild(characterEntity.getGuild());
        characterDTO.setItems(characterEntity.getItems());
        return characterDTO;
    }
}
