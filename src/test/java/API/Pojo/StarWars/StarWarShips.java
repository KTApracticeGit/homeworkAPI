package API.Pojo.StarWars;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class StarWarShips {

    @Test
    public void getStarShips() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("swapi.dev").setPath("api/starships");

        HttpGet get = new HttpGet(uriBuilder.build());

        get.setHeader("Accept","application/json");
        HttpResponse response = client.execute(get);
        ObjectMapper mapper = new ObjectMapper();
        StarshipsPojo deserializedResponse = mapper.readValue(response.getEntity().getContent(),StarshipsPojo.class);

        System.out.println(deserializedResponse.getCount());
        System.out.println(deserializedResponse.getResults().get(0).getName());
        System.out.println(deserializedResponse.getNext());
        System.out.println(deserializedResponse.getResults().get(0).getEdited());
    }
}
