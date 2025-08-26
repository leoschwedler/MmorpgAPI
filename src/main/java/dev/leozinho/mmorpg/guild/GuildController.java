package dev.leozinho.mmorpg.guild;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guild")
public class GuildController {



    // Adicionar guilda (CREATE)
    @PostMapping("/create")
    public void createGuild(){

    }
    // Procurar todas as guildas (READ)
    @GetMapping("/all")
    public void showAllGuilds(){

    }
    // Procurar guilda por id (READ)
    @GetMapping("/showGuildById")
    public void showGuildById(){

    }
    // Atualizar guilda por id (UPDATE)
    @PutMapping("/updateGuildById")
    public void updateGuildById(){

    }
    // Deletar guilda por id (DELETE)
    @DeleteMapping("/deleteGuildById")
    public void deleteGuildById(){

    }
}
