package com.zuora.dropwizard.service.resources;

import com.zuora.service.api.User;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces({MediaType.APPLICATION_JSON})
@Path("/user")
public class UserResource
{

    @GET
    public Response findUsers(@PathParam("userId") UUID userId) throws Exception
    {
        Map<String, String> result = Collections.emptyMap();
        return Response.ok().entity(Collections.singletonMap("data", result)).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addUser(final User.Builder userBuilder) throws Exception
    {
        userBuilder.id(UUID.randomUUID()).activated(false);

        return Response.ok().entity(userBuilder.build()).build();
    }
}
