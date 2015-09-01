package oss.tgc.stubber.controller;

/**
 * Created by rajeevguru on 01/07/15.
 */


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import oss.tgc.stubber.dao.JdbcQueries;
import oss.tgc.stubber.dao.StubDao;
import oss.tgc.stubber.model.StubInstance;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
        String responseHeader = stub.getResponseHeaders() !=null ? stub.getResponseHeaders():"";
        //if (response!=null && response.trim().length() > 0)
        stub.setResponse(new String(decoder.decode(response.getBytes())));

        //if (responseHeader !=null && responseHeader.trim().length()>0)
        stub.setResponseHeaders(new String(decoder.decode(responseHeader.getBytes())));
        stub = stubDao.createStub(stub);
        return Response.ok().type(MediaType.APPLICATION_JSON).entity(stub).build();
    }

    @POST
    @Path("stubv2")
    public Response addStubTest(JSONObject stub) {

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


}



