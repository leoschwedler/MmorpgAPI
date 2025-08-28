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
    public ItemDTO createItem(@RequestBody ItemDTO item){
        return service.createItem(item);
    }
    // Procurar todas os items (READ)
    @GetMapping("/all")
    public List<ItemDTO> showAllItems(){
      return   service.showAllItems();
    }
    // Procurar items por id (READ)
    @GetMapping("/showItemdById")
    public ItemDTO showItemById(@PathVariable Long id){
        return service.showItemById(id);
    }
    // Atualizar item por id (UPDATE)
    @PutMapping("/updateItemById/{id}")
    public ItemDTO updateItemById(@PathVariable Long id, @RequestBody ItemDTO item){
        return service.updateItemByid(id, item);
    }
    // Deletar item por id (DELETE)
    @DeleteMapping("/deleteItemById")
    public void deleteItemById(@PathVariable Long id){
        service.deleteItemById(id);
    }
}
