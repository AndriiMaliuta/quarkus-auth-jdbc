//package com.anma.qrk;
//
//import io.quarkus.oidc.RefreshToken;
//import org.eclipse.microprofile.jwt.JsonWebToken;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.inject.Inject;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//
//@Path("/auth/test")
//public class AuthResource {
//
//    @Inject
//    JsonWebToken token;
//
//    @Inject
//    RefreshToken refreshToken;
//
//    final Logger LOGGER = LoggerFactory.getLogger(AuthResource.class.getCanonicalName());
//
//    @GET
//    public String getTokens() {
//
//        StringBuilder builder = new StringBuilder().append("<div>");
//
//        Object username = this.token.getClaim("preferred_username");
//
//        LOGGER.info("**** token == " + token.getRawToken());
//
//        if (username != null) {
//            builder.append(username.toString());
//        }
//
//        Object scopes = this.token.getClaim("scope");
//
//        if (refreshToken != null) {
//            builder.append(refreshToken);
//        }
//
//        builder.append("</div>");
//
//        return  builder.toString();
//    }
//}
