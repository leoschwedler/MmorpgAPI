package dev.leozinho.mmorpg.guild;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guild")
public class GuildController {

    private GuildService service;

    public GuildController(GuildService service) {
        this.service = service;
    }

    // Adicionar guilda (CREATE)
    @PostMapping("/create")
    public GuildDTO createGuild(@RequestBody GuildDTO guild){
       return service.createGuild(guild);
    }
    // Procurar todas as guildas (READ)
    @GetMapping("/all")
    public List<GuildDTO> showAllGuilds(){
        return service.showAllGuilds();
    }
    // Procurar guilda por id (READ)
    @GetMapping("/showGuildById/{id}")
    public GuildDTO showGuildById(@PathVariable Long id){
        return service.showGuildById(id);
    }
    // Atualizar guilda por id (UPDATE)
    @PutMapping("/updateGuildById")
    public GuildDTO updateGuildById(@PathVariable Long id, @RequestBody GuildDTO guild){
        return service.updateGuildById(id,guild);
    }
    // Deletar guilda por id (DELETE)
    @DeleteMapping("/deleteGuildById/{id}")
    public void deleteGuildById(@PathVariable Long id){
        service.deleteGuildById(id);
    }
}
