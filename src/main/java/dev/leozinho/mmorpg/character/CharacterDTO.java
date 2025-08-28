package dev.leozinho.mmorpg.character;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.leozinho.mmorpg.guild.GuildEntity;
import dev.leozinho.mmorpg.item.ItemEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {

    private Long id;

    private String name;

    private int level;

    private String characterClass;

    private GuildEntity guild;

    private List<ItemEntity> items;
}
