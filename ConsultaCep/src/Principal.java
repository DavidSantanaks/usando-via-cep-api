import GeradoraDeArquivos.GerarArquivoComCeps;
import MetodosRapidos.Validadores;
import Request.BuscaCep;
import Records.Endereco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BuscaCep cep = new BuscaCep();
        String resp = "";
        List<Endereco> cepsArmazenados = new ArrayList<>();

        while (!resp.equals("sair")) {
            //Solicitando cep
            System.out.print("Informe o seu cep: ");
            resp = scan.nextLine();

            //Validando resposta
            if (resp.equals("sair")) {
                break;
            }

            Validadores validaCEP = new Validadores();
            if (validaCEP.validadores(cep.getCep(resp))  == false){
                System.out.println("CEP invalido");
            }else{
                try {
                    Endereco endereco = cep.getCep(resp);
                    GerarArquivoComCeps gerarArquivoComCeps = new GerarArquivoComCeps();
                    cepsArmazenados.add(endereco);
                    gerarArquivoComCeps.gerarArq(cepsArmazenados);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (cepsArmazenados.size() == 0) {
            System.out.println("Nenhum cep foi informado");
        } else {
            System.out.println("CEPS INFORMADOS");
            System.out.println(cepsArmazenados.toString());
        }
    }

}
