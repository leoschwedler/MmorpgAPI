package dev.leozinho.mmorpg.item;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

   private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    // Adicionar item (CREATE)
    @PostMapping("/create")
    public ItemEntity createItem(@RequestBody ItemEntity item){
        return service.createItem(item);
    }
    // Procurar todas os items (READ)
    @GetMapping("/all")
    public List<ItemEntity> showAllItems(){
      return   service.showAllItems();
    }
    // Procurar items por id (READ)
    @GetMapping("/showItemdById")
    public ItemEntity showItemById(@PathVariable Long id){
        return service.showItemById(id);
    }
    // Atualizar item por id (UPDATE)
    @PutMapping("/updateItemById/{id}")
    public ItemEntity updateItemById(@PathVariable Long id, @RequestBody ItemEntity item){
        return service.updateItemByid(id, item);
    }
    // Deletar item por id (DELETE)
    @DeleteMapping("/deleteItemById")
    public void deleteItemById(@PathVariable Long id){
        service.deleteItemById(id);
    }
}
