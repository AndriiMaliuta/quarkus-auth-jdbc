package com.anma.qrk;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/home")
@PermitAll
//@RolesAllowed({"user", "admin"})
public class HomeResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHome() {
        return "<h1>Home</h1><p>Hello to home page</p>";
    }
}
