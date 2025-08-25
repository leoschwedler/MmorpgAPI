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
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "character_id")
    private CharacterEntity character;

}
