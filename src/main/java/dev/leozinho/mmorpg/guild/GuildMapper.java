package dev.leozinho.mmorpg.guild;

import org.springframework.stereotype.Component;

@Component
public class GuildMapper {

    public GuildEntity map(GuildDTO guildDTO) {
        GuildEntity guildEntity = new GuildEntity();
        guildEntity.setId(guildDTO.getId());
        guildEntity.setName(guildDTO.getName());
        guildEntity.setDescription(guildDTO.getDescription());
        return guildEntity;
    }

    public GuildDTO map(GuildEntity guildEntity) {
        GuildDTO guildDTO = new GuildDTO();
        guildDTO.setId(guildEntity.getId());
        guildDTO.setName(guildEntity.getName());
        guildDTO.setDescription(guildEntity.getDescription());
        return guildDTO;
    }
 }
