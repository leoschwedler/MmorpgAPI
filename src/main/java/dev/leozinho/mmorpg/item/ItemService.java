package dev.leozinho.mmorpg.item;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    final private ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    // Adicionar item (CREATE)
    public ItemEntity createItem(ItemEntity item){
        return repository.save(item);
    }

    // Listar todos os items (READ)
    public List<ItemEntity> showAllItems(){
        return repository.findAll();
    }

    // Listar item por id (READ)
    public ItemEntity showItemById(Long id){
        Optional<ItemEntity> item = repository.findById(id);
        return item.orElse(null);
    }

    // Atualizar item (UPDATE)
    public ItemEntity updateItemByid(Long id, ItemEntity item){
        if (repository.existsById(id)){
            item.setId(id);
         return repository.save(item);
        }else {
            return null;
        }
    }

    // Deletar item (DELETE)
    public void deleteItemById(Long id){
        repository.deleteById(id);
    }
}
