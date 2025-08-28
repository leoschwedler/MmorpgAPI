package dev.leozinho.mmorpg.guild;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guild")
public class GuildController {

    private final GuildService service;

    public GuildController(GuildService service) {
        this.service = service;
    }

    // ================================
    // CREATE - Criar nova guilda
    // ================================
    @PostMapping("/create")
    public ResponseEntity<?> createGuild(@RequestBody GuildDTO guild) {
        GuildDTO created = service.createGuild(guild);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Guild criada com sucesso: " + created.getName() +
                        " (ID: " + created.getId() + ")");
    }

    // ================================
    // READ - Listar todas as guildas
    // ================================
    @GetMapping("/all")
    public ResponseEntity<?> showAllGuilds() {
        List<GuildDTO> guilds = service.showAllGuilds();
        if (guilds.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(guilds);
    }

    // ================================
    // READ - Buscar guilda por ID
    // ================================
    @GetMapping("/showGuildById/{id}")
    public ResponseEntity<?> showGuildById(@PathVariable Long id) {
        GuildDTO guild = service.showGuildById(id);
        if (guild != null) {
            return ResponseEntity.ok(guild);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Guild com o ID: " + id + " não foi encontrada");
        }
    }

    // ================================
    // UPDATE - Atualizar guilda por ID
    // ================================
    @PutMapping("/updateGuildById/{id}")
    public ResponseEntity<?> updateGuildById(@PathVariable Long id, @RequestBody GuildDTO guild) {
        GuildDTO guildExist = service.showGuildById(id);
        if (guildExist != null) {
         GuildDTO  guildDTO = service.updateGuildById(id, guild);
            return ResponseEntity.ok(guildDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro ao encontrar a guild com o ID: " + id);
        }
    }

    // ================================
    // DELETE - Deletar guilda por ID
    // ================================
    @DeleteMapping("/deleteGuildById/{id}")
    public ResponseEntity<?> deleteGuildById(@PathVariable Long id) {
        GuildDTO guild = service.showGuildById(id);
        if (guild != null)  {
            service.deleteGuildById(id);
            return ResponseEntity.ok("Guild com o ID: " + id + " foi deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Guild com o ID: " + id + " não encontrada");
        }
    }
}