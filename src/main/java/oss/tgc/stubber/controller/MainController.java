package oss.tgc.stubber.controller;

/**
 * Created by rajeevguru on 01/07/15.
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import oss.tgc.stubber.dao.StubDao;
import oss.tgc.stubber.model.StubInstance;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Base64;
import java.util.List;

@Component
@Path("/api")
public class MainController {

    @Autowired
    StubDao stubDao;



    @POST
    @Path("stub")
    public Response addStub(StubInstance stub) {



        Base64.Decoder decoder = Base64.getDecoder();
        String response = stub.getResponse()!=null ? stub.getResponse():"";
        String responseHeader = stub.getHeaders() !=null ? stub.getHeaders():"";
        //if (response!=null && response.trim().length() > 0)
        stub.setResponse(new String(decoder.decode(response.getBytes())));

        //if (responseHeader !=null && responseHeader.trim().length()>0)
        stub.setHeaders(new String(decoder.decode(responseHeader.getBytes())));
        stub = stubDao.createStub(stub);
        return Response.ok().type(MediaType.APPLICATION_JSON).entity(stub).build();
    }

    @PUT
    @Path("stub/{id}")
    public Response updateStub(StubInstance stub) {



        Base64.Decoder decoder = Base64.getDecoder();
        String response = stub.getResponse()!=null ? stub.getResponse():"";
        String responseHeader = stub.getHeaders() !=null ? stub.getHeaders():"";
        //if (response!=null && response.trim().length() > 0)
        stub.setResponse(new String(decoder.decode(response.getBytes())));

        //if (responseHeader !=null && responseHeader.trim().length()>0)
        stub.setHeaders(new String(decoder.decode(responseHeader.getBytes())));
        stub = stubDao.updateStub(stub);
        return Response.ok().type(MediaType.APPLICATION_JSON).entity(stub).build();
    }

    @GET
    @Path("stub")
    public Response listStubs() {

        List<StubInstance> stubInstanceList = stubDao.getAll();

        return Response.ok().type(MediaType.APPLICATION_JSON).entity(stubInstanceList).build();
    }

    @DELETE
    @Path("stub/{id}")
    public Response deleteStub(@PathParam("id") Long id) {

        int rows = stubDao.deleteStub(id);
        return Response.ok().type(MediaType.APPLICATION_JSON).entity("{\"rows\": " + rows + " }").build();


    }


    @GET
    @Path("stub/{id}")
    public Response getStub(@PathParam("id") Long id) {

        StubInstance stub = stubDao.getStub(id);
        return Response.ok().type(MediaType.APPLICATION_JSON).entity(stub).build();


    }


}



