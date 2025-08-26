package dev.leozinho.mmorpg.guild;

import dev.leozinho.mmorpg.character.CharacterEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_guild")
public class GuildEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    // =====================================
    // RELACIONAMENTO ONE-TO-MANY COM CHARACTERS
    // =====================================
    @OneToMany(mappedBy = "guild")
    // Uma guilda pode ter vários personagens.
    // O 'mappedBy = "guild"' indica que a propriedade 'guild' em CharacterEntity
    // é quem "possui" o relacionamento no banco de dados.
    // Ou seja, a tabela tb_character tem a coluna guild_id que referencia tb_guild.
    private List<CharacterEntity> characters;
}
