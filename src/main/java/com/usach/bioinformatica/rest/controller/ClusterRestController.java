package com.usach.bioinformatica.rest.controller;


import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@RestController
@RequestMapping("/clustering")
@Api(value = "/clustering", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
@Path("/clustering")

public class ClusterRestController {

    @Path("/upload")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("aFile") InputStream fileInputString,
            @FormDataParam("aFile") FormDataContentDisposition fileInputDetails) {

        String status = "dasdasdasd";
        ClusterResponse clusterResponse = new ClusterResponse();
        clusterResponse.setId(1);


        return Response.status(200).entity(clusterResponse).build();
    }

    @RequestMapping(value = "matriz", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "Inject a new messagge in Sicco Engine", notes = "...", response = ClusterResponse.class, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody ClusterResponse helloworld(@RequestBody String id) {
        ClusterResponse clusterResponse = new ClusterResponse();
        clusterResponse.setId(1);
        return clusterResponse;
    }

}
