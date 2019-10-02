package com.zensar.webservice.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService 
{
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String  sayPlainHello()
	{
		return("Welcome to Zensar HelloService");
	}
	
	@Path("/html")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String htmlHello()
	{
		return"<html>" + "<title>" + "Hello" + "</title>" + "<body>" + "<h1>" + "Welcome TO Zensar" + 
	"</h1>" +"</body>" + "</html>";
	}
	
	@Path("/xml")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String xmlHello()
	{
		return"<?xml version='1.0'?><hello>Welcome To Zensar</hello>";
	}
}
