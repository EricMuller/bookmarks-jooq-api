package com.emu.apps.bookmarks.web.rest.dtos;

import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "Bookmark")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class BookmarkDto extends EntityInputDto {


    @ApiModelProperty(notes = "The title of the Bookmark")
    public String title;
    @ApiModelProperty(notes = "The url of the Bookmark")
    public String url;
    @ApiModelProperty(notes = "The description of the Bookmark")
    public String description;

    public BookmarkDto(long id, String title, String url, String description) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
    }

} 
