package Geradora;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.CepModelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {

    public void salvaJson(List cep) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file = new FileWriter("Ceps.json");
        file.write(gson.toJson(cep));
        file.close();
    }


}