package dev.leozinho.mmorpg.guild;

import dev.leozinho.mmorpg.character.CharacterEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuildService {

    private final GuildRepository repository;

    public GuildService(GuildRepository repository) {
        this.repository = repository;
    }

    // Adicionar guilda (CREATE)
    public GuildEntity createGuild(GuildEntity guilda){
        return repository.save(guilda);
    }

    // Listar todas as guildas (fREAD)
    public List<GuildEntity> showAllGuilds(){
        return repository.findAll();
    }

    // Listar guilda por id (READ)
    public GuildEntity showGuildById(Long id){
        Optional<GuildEntity> guilda = repository.findById(id);
        return guilda.orElse(null);
    }

    // Atualizar guilda (UPDATE)
    public GuildEntity updateGuildById(Long id, GuildEntity guild){
        if (repository.existsById(id)){
            guild.setId(id);
            return repository.save(guild);
        }else {
            return null;
        }
    }

    // Deletar guilda (DELETE)
    public void deleteGuildById(Long id){
        repository.deleteById(id);
    }

}
