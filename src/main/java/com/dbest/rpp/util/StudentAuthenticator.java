/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ftadewale
 */

@SecuredStudent
@Provider
@Priority(Priorities.AUTHENTICATION)
public class StudentAuthenticator implements ContainerRequestFilter {
    
    @EJB
    JWTHelper jwt;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader =
            requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        String token = authorizationHeader.substring("Bearer ".length()).trim(); 
        Map<String, String> payload = jwt.validateToken(token);
        String valid = payload.get("message");
        String flag = payload.getOrDefault("flag", "student");
        valid = flag.equals("student") ? valid : "You do not have permission to access this route";
        
        if(!valid.equalsIgnoreCase("valid") || !flag.equals("student")){
            abortWithUnauthorized(requestContext, valid);
        }
    }
    
    
    
    private void abortWithUnauthorized(ContainerRequestContext requestContext, String errorMsg) {
        Map<String, String> resData =  new HashMap<>();
        resData.put("message", errorMsg);

        // Abort the filter chain with a 401 status code response
        // The WWW-Authenticate header is sent along with the response
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED).entity(resData)
                        .build());
    }
  
    
}
