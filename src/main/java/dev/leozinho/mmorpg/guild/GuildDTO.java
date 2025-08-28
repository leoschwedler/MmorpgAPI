package dev.leozinho.mmorpg.guild;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.leozinho.mmorpg.character.CharacterEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuildDTO {

    private Long id;

    private String name;

    private String description;

    private List<CharacterEntity> characters;
}
