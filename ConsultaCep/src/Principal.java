import GeradoraDeArquivos.GerarArquivoComCeps;
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

            } else if(resp.length() < 8 || resp.length() > 9 ){ //Valida tamanho
                System.out.println("Cep de tamanho invalido");

            }else {
                Endereco endereco = (cep.getCep(resp));
                if (endereco.cep() == null){//Valida se o campo é nulo
                    System.out.println("CEP invalido");
                }else{
                    GerarArquivoComCeps gerar = new GerarArquivoComCeps();
                    cepsArmazenados.add(endereco);
                    try {
                        gerar.gerarArq(cepsArmazenados);
                    } catch (IOException e) {
                        System.out.println("CEP invalido");
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        if(cepsArmazenados.size() == 0){
            System.out.println("Nenhum cep foi informado");
        }else{
            System.out.println("CEPS INFORMADOS");
            System.out.println(cepsArmazenados.toString());
        }
    }

}
