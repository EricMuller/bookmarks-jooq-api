package com.emu.apps.bookmarks.web.rest.controllers;

import com.emu.apps.bookmarks.services.jooq.TagJooqRepository;
import com.emu.apps.bookmarks.services.jooq.tables.pojos.Tag;
import com.emu.apps.bookmarks.web.rest.TagRestApi;
import com.emu.apps.bookmarks.web.rest.dtos.TagInputDto;
import com.emu.apps.bookmarks.web.rest.dtos.TagOutPutDto;
import com.emu.apps.bookmarks.web.rest.mappers.TagMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TagRestController implements TagRestApi {

    protected static final Logger LOGGER = LoggerFactory.getLogger(TagRestController.class);

    private TagJooqRepository tagJooqRepository;

    private TagMapper tagMapper;

    @Autowired
    public TagRestController(TagJooqRepository tagJooqRespository, TagMapper tagMapper) {
        this.tagJooqRepository = tagJooqRespository;
        this.tagMapper = tagMapper;
    }

    @Override
    public TagOutPutDto getTagById(long id) {
        return tagJooqRepository.findOne(id).into(TagOutPutDto.class);
    }

    @Override
    public TagOutPutDto saveTag(@RequestBody TagInputDto inputDto) {
        Tag tag = tagMapper.dtoToModel(inputDto);
        return tagJooqRepository.save(tag).into(TagOutPutDto.class);

    }

    @Override
    public Iterable<TagOutPutDto> getTags() {
        List<TagOutPutDto> list = new ArrayList<>();
        tagJooqRepository.findAll().stream()
                .forEach(addressRecord -> list.add(addressRecord.into(TagOutPutDto.class)));
        return list;
    }

}
