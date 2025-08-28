package dev.leozinho.mmorpg.item;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    final private ItemRepository repository;
    final private ItemMapper mapper;

    public ItemService(ItemRepository repository, ItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Adicionar item (CREATE)
    public ItemDTO createItem(ItemDTO itemDTO){
        ItemEntity item = mapper.map(itemDTO);
        item = repository.save(item);
        return mapper.map(item);
    }

    // Listar todos os items (READ)
    public List<ItemDTO> showAllItems(){
        List<ItemEntity> item = repository.findAll();
        return item.stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    // Listar item por id (READ)
    public ItemDTO showItemById(Long id){
       Optional<ItemEntity> item = repository.findById(id);
       return item.map(mapper::map).orElse(null);
    }

    // Atualizar item (UPDATE)
    public ItemDTO updateItemByid(Long id, ItemDTO itemDTO){
       Optional<ItemEntity> item = repository.findById(id);
       if (item.isPresent()){
           ItemEntity itemExist = mapper.map(itemDTO);
           itemExist.setId(id);
           ItemEntity itemSaved = repository.save(itemExist);
           return mapper.map(itemSaved);
       }
       return null;
    }

    // Deletar item (DELETE)
    public void deleteItemById(Long id){
        repository.deleteById(id);
    }
}
