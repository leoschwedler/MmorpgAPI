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
    // =========================
    // RELACIONAMENTO MANY-TO-ONE
    // =========================
    // Essa anotação diz que muitos personagens podem pertencer a uma guilda.
    // No banco de dados, isso cria uma coluna 'guild_id' na tabela 'tb_character'
    // que será a chave estrangeira apontando para a tabela 'tb_guild'.
    @ManyToOne
    @JoinColumn(name = "guild_id")
    // Aqui estamos explicitamente dizendo o nome da coluna que será usada
    // como chave estrangeira (foreign key) para a GuildEntity.
    private GuildEntity guild;
    // =========================
    // RELACIONAMENTO ONE-TO-MANY
    // =========================
    @OneToMany(mappedBy = "character")
    // Essa anotação diz que um personagem pode ter muitos itens.
    // O 'mappedBy' indica que o lado "dono" do relacionamento é a entidade ItemEntity,
    // que terá uma propriedade chamada 'character' apontando para este CharacterEntity.
    private List<ItemEntity> items;
}
