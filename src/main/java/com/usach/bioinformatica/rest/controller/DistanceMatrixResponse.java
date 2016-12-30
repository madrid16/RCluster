package com.usach.bioinformatica.rest.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonSerialize
public class DistanceMatrixResponse {

    @ApiModelProperty(value = "process gens", required = true)
    private List<String> gens;

}
