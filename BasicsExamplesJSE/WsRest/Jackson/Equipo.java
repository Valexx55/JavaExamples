package curso.exp;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

@Path("/equipo")
public class Equipo {
	
	 	@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public Response creaPersona(Persona p) {
	 		
	 		System.out.println("desde put json");
	 		System.out.println(p.toString());
	        
			String result = "Ha ido bien, chaval ;)";
			return Response.status(201).entity(result).build();
	 
		}
	 
	 	@PUT
		@Consumes(MediaType.APPLICATION_XML)
		public Response creaPersonaXml(JAXBElement<Persona> xml_persona) {
		 
	 		System.out.println("desde put xml");
	 		
	 		System.out.println(xml_persona.getName());
	 		Persona precb = xml_persona.getValue();
	 		System.out.println(precb.toString());
	        
			String result = "Ha ido bien, chaval ;)";
			return Response.status(201).entity(result).build();
	 
		}
	 
}
