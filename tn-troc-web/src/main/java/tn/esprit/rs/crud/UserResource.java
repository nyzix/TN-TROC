package tn.esprit.rs.crud;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
@Path("users")

public class UserResource {
	static List<User> users=new ArrayList<User>();
	@POST
	@Consumes(MediaType.APPLICATION_XML)	 //entrée
	@Produces(MediaType.TEXT_PLAIN)			//la sortie : retourne la valeur booleene
	public boolean addUser(User u) // POST /users
	{
	
		return users.add(u);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers()	//GET /users
	{
		return users;
	}
	@GET
	@Path("{id}") // parametre fel requete
	@Produces(MediaType.APPLICATION_XML)
	public Response getUserBy(@PathParam("id")int id) //GET users/{id}
	{
		for(User u:users)
		{
			if(u.getId()==id)
				return Response.status(Status.OK).entity(u).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean deleteUser(int id) //DELETE users/{id}
	{
	
			for(User u:users)
			{
				if(u.getId()==id)
					users.remove(u);
			}
			return false;
	}
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_XML)
		public boolean updateUser(@PathParam("id")int id,User updateduser) //PUT users/{id}
		{
			for(User us:users)
			{
				if(us.getId()==id){
					int index=users.indexOf(updateduser);
				users.set(index, updateduser);
				return true;
				}
			}
			return false;
		}
}

