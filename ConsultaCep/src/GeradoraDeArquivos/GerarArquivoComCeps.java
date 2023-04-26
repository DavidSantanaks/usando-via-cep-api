package GeradoraDeArquivos;

import Records.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GerarArquivoComCeps {

    public void gerarArq(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file =  new FileWriter("CEPS.json");
        file.write(gson.toJson(endereco));
        file.close();
    }


    public void gerarArq(List<Endereco> endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file =  new FileWriter("CEPS.json");
        file.write(gson.toJson(endereco));
        file.close();
    }
}
