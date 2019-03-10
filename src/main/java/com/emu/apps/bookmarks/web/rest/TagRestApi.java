package com.emu.apps.bookmarks.web.rest;


import com.emu.apps.bookmarks.services.jooq.tables.pojos.Tag;
import com.emu.apps.bookmarks.web.rest.dtos.TagInputDto;
import com.emu.apps.bookmarks.web.rest.dtos.TagOutPutDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;


@RequestMapping(BookmarkApi.API_V1 + "/tags")
@Api(value = "tag-store", description = "Operations on Tags", tags = "Tags")
public interface TagRestApi {

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ApiOperation(value = "get tag by ID", response = TagOutPutDto.class)
    @ResponseBody
    TagOutPutDto getTagById(@PathVariable("id") long id);

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    @ApiOperation(value = "View a list of tags", responseContainer = "Iterable", response = TagOutPutDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @ResponseBody
    Iterable<TagOutPutDto> getTags();


    @ApiOperation(value = "Save a Tag", response = TagOutPutDto.class, nickname = "saveTag")
    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
    @ResponseBody
    TagOutPutDto saveTag(@ApiParam(value = "Tag value", required = true, type = "TagInputDto") @RequestBody TagInputDto tagDto);

}
