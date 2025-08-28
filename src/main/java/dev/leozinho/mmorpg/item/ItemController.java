package dev.leozinho.mmorpg.item;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createItem(@RequestBody ItemDTO ItemDTO){
        ItemDTO item = service.createItem(ItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Item criado com sucesso: " + item.getName() + " ID: " + item.getId());
    }
    // Procurar todas os items (READ)
    @GetMapping("/all")
    public ResponseEntity<List<ItemDTO>> showAllItems(){
      List<ItemDTO> items = service.showAllItems();
      return ResponseEntity.ok(items);
    }
    // Procurar items por id (READ)
    @GetMapping("/showItemdById/{id}")
    public ResponseEntity<?> showItemById(@PathVariable Long id){
        ItemDTO item = service.showItemById(id);
        if (item != null){
            service.showItemById(id);
            return ResponseEntity.ok(item);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O item com o ID:" + id + " nao foi encontrado");
        }
    }
    // Atualizar item por id (UPDATE)
    @PutMapping("/updateItemById/{id}")
    public ResponseEntity<?> updateItemById(@PathVariable Long id, @RequestBody ItemDTO itemDto){
        ItemDTO item = service.showItemById(id);
        if ( item != null) {
            service.updateItemByid(id, itemDto);
            return ResponseEntity.ok(item);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O item com o ID: " + id + " nao foi encontrado");
        }
    }
    // Deletar item por id (DELETE)
    @DeleteMapping("/deleteItemById/{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable Long id){
        if (service.showItemById(id) != null){
            service.deleteItemById(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " Deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O item com o id: " + id + " nao foi encontrado");
        }
    }
}
