package com.usach.bioinformatica.rest.controller;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonSerialize
public class ClusterResponse {

    @ApiModelProperty(value = "process id", required = true)
    private int id;
}
