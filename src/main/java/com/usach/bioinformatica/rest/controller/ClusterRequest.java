package com.usach.bioinformatica.rest.controller;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterRequest {

    @JsonProperty
    @ApiModelProperty(value = "LATAM Event Message Payload", required = true)
    private String payload;

}
