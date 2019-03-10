package com.emu.apps.bookmarks.web.rest.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by eric on 05/06/2017.
 */
@ApiModel(value = "TagOutPutDto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class TagOutPutDto extends EntityOutPutDto {

    @ApiModelProperty(notes = "Libelle")
    @JsonProperty("libelle")
    private String libelle;


}
