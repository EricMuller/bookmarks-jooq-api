package com.emu.apps.bookmarks.web.rest.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public abstract class EntityInputDto {

    @ApiModelProperty(notes = "The database generated product ID")
    @JsonProperty("id")
    protected Long id;

    @ApiModelProperty(notes = "The database generated version record")
    @JsonProperty("version")
    private Long version;

}
