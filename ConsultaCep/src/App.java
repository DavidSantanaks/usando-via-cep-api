import Geradora.GeradorDeArquivo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.CepModelo;
import record.CepRecord;
import request.RequisitaCep;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES).setPrettyPrinting().create();
        Scanner scan = new Scanner(System.in);
        List<CepModelo> ceps = new ArrayList<>();
        String cep = "";
        String json = "";


        while (cep != "sair") {

            //Solicita o cep
            System.out.print("Informe o cep: ");
            cep = scan.nextLine();

            if (cep.equalsIgnoreCase("sair")) {
                break;
            }else if (cep.length() < 8 || cep.length() > 9 ) {
                System.out.println("Infome um cep com 8 numeros");
                System.out.print("Informe o cep: ");
                cep = scan.nextLine();
            }
            //realiza a requisição do CEP
            RequisitaCep resq = new RequisitaCep(cep);
            json = resq.getResp();
            //Passa o cep via a classe record
            CepRecord cepRecord = gson.fromJson(json, CepRecord.class);
            //Classe record informa na clase correta
            CepModelo cepCorreto = new CepModelo(cepRecord);
            ceps.add(cepCorreto);
        }

        GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
        for (int i = 0; i < ceps.size(); i++){
            geradorDeArquivo.salvaJson(ceps);
        }
        System.out.println("fim");

    }
}
