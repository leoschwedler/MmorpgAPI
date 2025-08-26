package dev.leozinho.mmorpg.item;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {


    // Adicionar item (CREATE)
    @PostMapping("/create")
    public void createItem(){

    }
    // Procurar todas os items (READ)
    @GetMapping("/all")
    public void showAllItems(){

    }
    // Procurar items por id (READ)
    @GetMapping("/showGuildById")
    public void showItemById(){

    }
    // Atualizar item por id (UPDATE)
    @PutMapping("/updateItemById")
    public void updateItemById(){

    }
    // Deletar item por id (DELETE)
    @DeleteMapping("/deleteItemById")
    public void deleteItemById(){

    }
}
