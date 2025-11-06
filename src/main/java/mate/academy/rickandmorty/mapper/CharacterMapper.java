package mate.academy.rickandmorty.mapper;

import mate.academy.rickandmorty.config.MapperConfig;
import mate.academy.rickandmorty.dto.CharacterDto;
import mate.academy.rickandmorty.model.CharacterRM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface CharacterMapper {

    @Mapping(target = "id", expression = "java(Long.valueOf(character.getExternalId()))")
    @Mapping(target = "externalId", ignore = true)
    CharacterDto toDto(CharacterRM character);

    @Mapping(target = "externalId", expression = "java(String.valueOf(dto.id()))")
    @Mapping(target = "dbId", ignore = true)
    CharacterRM toEntity(CharacterDto dto);
}
