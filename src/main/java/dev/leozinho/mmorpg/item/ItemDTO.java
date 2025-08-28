package dev.leozinho.mmorpg.item;

import dev.leozinho.mmorpg.character.CharacterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private Long id;

    private String name;

    private String type;

    private int damage;

    private CharacterEntity character;
}
