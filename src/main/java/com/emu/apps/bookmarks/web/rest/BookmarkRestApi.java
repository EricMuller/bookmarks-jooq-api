package com.emu.apps.bookmarks.web.rest;

import com.emu.apps.bookmarks.web.rest.dtos.BookmarkDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequestMapping(BookmarkApi.API_V1 + "/bookmark")
@Api(value = "bookmark-store", description = "Operations on Bookmarks", tags = "Bookmarks")
public interface BookmarkRestApi {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ApiOperation(value = "Dummy Test ", response = String.class)
    String test();

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Search a bookmark with an ID", response = BookmarkDto.class)
    @ResponseBody
    BookmarkDto getBookmark(@PathVariable("id") long id);


    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    @ApiOperation(value = "View a list of bookmarks", responseContainer = "List", response = BookmarkDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @ResponseBody
    List <BookmarkDto> getBookmarks();
}
