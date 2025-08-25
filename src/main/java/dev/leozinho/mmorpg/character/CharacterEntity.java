package dev.leozinho.mmorpg.character;

import dev.leozinho.mmorpg.guild.GuildEntity;
import dev.leozinho.mmorpg.item.ItemEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_character")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "level")
    private int level;
    @Column(name = "class")
    private String characterClass;
    @ManyToOne
    @JoinColumn(name = "guild_id")
    private GuildEntity guild;
    @OneToMany(mappedBy = "character")
    private List<ItemEntity> itemEntityList;
}
