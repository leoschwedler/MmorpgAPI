package dev.leozinho.mmorpg.item;

import dev.leozinho.mmorpg.character.CharacterEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    // =========================
    // RELACIONAMENTO MANY-TO-ONE COM CHARACTER
    // =========================
    @ManyToOne
    // Muitos itens podem pertencer a um mesmo personagem.
    // Cada item tem apenas um dono (CharacterEntity).
    @JoinColumn(name = "character_id")
    // Define o nome da coluna no banco que será a chave estrangeira apontando para tb_character.
    private CharacterEntity character;

}
