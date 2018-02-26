package com.arvind.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        
    	for( int number = 2; number <= 50; number ++ ) {
    	
    		boolean isPrime = true;
	    	for( int x = 2; x < number; x ++ ) {
	    		
	    		if ( number % x == 0 ) {
	    			isPrime = false;
	    			break;
	    		}	    		
	    	}
	    	if ( isPrime )
	    	System.out.println( "Number " + number + " is Prime !" );
    	}
    	
    	
    	JSONObject json = new JSONObject();
    	json.put("key", "value");
    	return "{\"key\":\"Got it!\"}";
    	//return json;
    	
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String postIt( @FormParam("stripeToken") String token ) {
        
    	JSONObject json = new JSONObject();
    	json.put("key", "value");
    	//return "{\"key\":\"Got it!\"}";
    	return token;
    	
    }
}
