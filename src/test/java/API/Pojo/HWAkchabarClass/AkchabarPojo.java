package API.Pojo.HWAkchabarClass;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class AkchabarPojo {

    @Test
    public void getAkchabar() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http").setHost("rates.akchabar.kg").setPath("get.json");
        HttpGet get = new HttpGet(uriBuilder.build());
        get.setHeader("Accept","application/json");
        HttpResponse response = client.execute(get);
        ObjectMapper objectMapper = new ObjectMapper();
        Akchabar deserializedResponse = objectMapper.readValue(response.getEntity().getContent(), Akchabar.class);

        System.out.println(deserializedResponse.getRates().getEuro());
        System.out.println(deserializedResponse.getDate());
        System.out.println(deserializedResponse.getUpdated_at());
    }
}
