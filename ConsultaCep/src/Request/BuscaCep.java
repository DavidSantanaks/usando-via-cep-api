package Request;

import Records.Endereco;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCep {

    public Endereco getCep(String cep) {

        if(cep.equals("sair")){
            System.out.println("Saindo do programa");
        }else{
            try {
                var url = "https://viacep.com.br/ws/" + cep + "/json";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Endereco.class);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }


}

