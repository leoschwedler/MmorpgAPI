package dev.leozinho.mmorpg.guild;

import dev.leozinho.mmorpg.character.CharacterEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class GuildService {

    private final GuildRepository repository;
    private final GuildMapper mapper;

    public GuildService(GuildRepository repository, GuildMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Adicionar guilda (CREATE)
    public GuildDTO createGuild(GuildDTO guilda){
        GuildEntity guild = mapper.map(guilda);
        guild = repository.save(guild);
        return mapper.map(guild);
    }

    // Listar todas as guildas (READ)
    public List<GuildDTO> showAllGuilds(){
        List<GuildEntity> guild = repository.findAll();
        return guild.stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    // Listar guilda por id (READ)
    public GuildDTO showGuildById(Long id){
        Optional<GuildEntity> guilda = repository.findById(id);
        return guilda.map(mapper::map).orElse(null);
    }

    // Atualizar guilda (UPDATE)
    public GuildDTO updateGuildById(Long id, GuildDTO guildDTO){
       Optional<GuildEntity> guild = repository.findById(id);
       if (guild.isPresent()){
           GuildEntity guildExist = mapper.map(guildDTO);
           guildExist.setId(id);
           GuildEntity guildSaved = repository.save(guildExist);
           return mapper.map(guildSaved);
       }
       return null;
    }

    // Deletar guilda (DELETE)
    public void deleteGuildById(Long id){
        repository.deleteById(id);
    }

}
