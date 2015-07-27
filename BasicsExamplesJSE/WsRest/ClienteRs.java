import javax.xml.bind.annotation.XmlRootElement;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


@XmlRootElement(name="persona")
public class ClienteRs {

	
	public static void main(String[] args) {
		 
		Client cliente = Client.create();
		
		WebResource webResource = cliente.resource("http://localhost:8085/WebServiceRest/rest/equipo/info/RM");
		
		String s = webResource.get(String.class);
		
		System.out.println(s);
		
		
		//EJEMPLO DE CASO DOS
		/*Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8085/WebServiceRest/rest/equipo/");

		String input = "{\"nombre\":\"Juanita\",\"edad\":\"31\"}";

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		System.out.println("Respuesta del servidor .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);
		*/
	}

}
