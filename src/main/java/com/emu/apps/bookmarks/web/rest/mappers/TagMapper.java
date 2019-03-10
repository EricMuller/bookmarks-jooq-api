package com.emu.apps.bookmarks.web.rest.mappers;


import com.emu.apps.bookmarks.services.jooq.tables.pojos.Tag;
import com.emu.apps.bookmarks.web.rest.dtos.TagInputDto;
import com.emu.apps.bookmarks.web.rest.dtos.TagOutPutDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface TagMapper {

    TagOutPutDto modelToDto(Tag tag);

    Tag dtoToModel(TagInputDto tagDto);

    Iterable<TagOutPutDto> modelsToDtos(Iterable<Tag> tags);

    default Page<TagOutPutDto> pageToDto(Page<Tag> page) {
        return page.map(this::modelToDto);
    }

}
