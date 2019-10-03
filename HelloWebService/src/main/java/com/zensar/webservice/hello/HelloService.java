package com.zensar.webservice.hello;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

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
	
	@GET
	@Path("/{nm}")
	@Produces("text/plain")
	public String sayHelloUser(@PathParam("nm") String name)
	{
		return "Dear "+name+"Welcome To Zensar Hello Service";
	}
	
	@GET
	@Path("res/{nm}")
	@Produces("text/plain")
	public Response sayHelloUserResponse(@PathParam("nm") String name)
	{
		Response res = Response.status(200).entity("Dear" +name+ "Welcome To Zensar Hello Service").build();
		return res;
	}
	
	@GET
	@Path("res/{nm}/{dd}/{mm}/{yy}")
	@Produces("text/plain")
	public Response sayHappyBirthday(@PathParam("nm") String name,@PathParam("dd") int day, @PathParam("mm") int month, @PathParam("yy")int year)
	{
		LocalDate birthdate = LocalDate.of(year,month,day);
		Response res = Response.status(200).entity("Dear" +name+"Happy Birthday on "+birthdate +" Welcome To Zensar Hello Service").build();
		return res;
	}
}
