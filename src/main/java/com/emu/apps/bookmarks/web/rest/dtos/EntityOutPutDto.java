package com.emu.apps.bookmarks.web.rest.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class EntityOutPutDto {

    @ApiModelProperty(notes = "The database generated product ID")
    @JsonProperty("id")
    protected Long id;

    @ApiModelProperty(notes = "Universal unique identifier")
    @JsonProperty("uuid")
    private  String uuid;

    @ApiModelProperty(notes = "The database generated version record")
    @JsonProperty("version")
    private Long version;

    @ApiModelProperty(notes = "The  Creation Date record")
    @JsonProperty("date_creation")
    private Date dateCreation;

    @ApiModelProperty(notes = "The last Modification Date record")
    @JsonProperty("date_modification")
    private Date dateModification;

    @ApiModelProperty(notes = "The user Creation record")
    @JsonProperty("user_creation")
    private String userCreation;
    @ApiModelProperty(notes = "The last Modification user record")
    @JsonProperty("user_modification")
    private String userModification;



}
