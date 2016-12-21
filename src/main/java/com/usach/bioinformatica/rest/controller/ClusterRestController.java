package com.usach.bioinformatica.rest.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/clustering")
@Api(value = "/clustering", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
@Path("/clustering")

public class ClusterRestController {

    @RequestMapping(value = "matriz", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "Inject a new messagge in Sicco Engine", notes = "...", response = ClusterResponse.class, produces = MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "code: 500 message: Internal service error </br>", response = String.class),
            @ApiResponse(code = 200, message = "code: 200 message: Successful </br>", response = ClusterResponse.class)
    })
    public @ResponseBody ClusterResponse helloworld(@RequestBody String id) {
        ClusterResponse clusterResponse = new ClusterResponse();
        clusterResponse.setId(1);
        return clusterResponse;
    }

}
