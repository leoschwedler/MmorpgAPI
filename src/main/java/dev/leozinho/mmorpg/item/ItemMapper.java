package dev.leozinho.mmorpg.item;

import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemEntity map(ItemDTO itemDTO){
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDTO.getId());
        itemEntity.setName(itemDTO.getName());
        itemEntity.setType(itemDTO.getType());
        itemEntity.setDamage(itemDTO.getDamage());
        itemEntity.setCharacter(itemDTO.getCharacter());
        return itemEntity;
    }

    public ItemDTO map(ItemEntity itemEntity){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(itemEntity.getId());
        itemDTO.setName(itemEntity.getName());
        itemDTO.setType(itemEntity.getType());
        itemDTO.setDamage(itemEntity.getDamage());
        itemDTO.setCharacter(itemEntity.getCharacter());
        return itemDTO;
    }
}
