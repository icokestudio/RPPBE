/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.util;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Priority;
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

@SecuredAdmin
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AdminAuthenticator implements ContainerRequestFilter {
    

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader =
            requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        
        if (authorizationHeader == null || !authorizationHeader.startsWith("Basic ")) {
            throw new NotAuthorizedException("Authorization header must be provided");
        }
        String token = authorizationHeader.substring("Basic ".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(token),"utf-8");
         
        if(!credentials.equals("resultprocessor@rpp.edu.ng:247processor")){
            abortWithUnauthorized(requestContext, "Invalid crendiatls");
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
