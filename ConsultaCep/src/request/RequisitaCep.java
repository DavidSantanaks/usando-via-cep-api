package request;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequisitaCep {

    private String cep;

    public RequisitaCep(String cep) {
        this.cep = cep;
    }

    public String getResp()  {
       HttpClient client = HttpClient.newHttpClient();
       HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://viacep.com.br/ws/"+ this.cep +"/json/")).build();

        try {
            HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
            return resp.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui busca o CEP");
        }


    }
}
