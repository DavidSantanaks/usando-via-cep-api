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
            if (resp.equals("sair")) {
                break;
            }

            //Validar resposta
            Validadores v = new Validadores();
            if (v.tamanhoCep(resp)) {
                Endereco end = cep.getCep(resp);
                if (v.cepInvalido(end) == true) {
                    try {
                        GerarArquivoComCeps g = new GerarArquivoComCeps();
                        cepsArmazenados.add(end);
                        g.gerarArq(cepsArmazenados);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
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
