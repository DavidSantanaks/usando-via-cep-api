package Records;

public record Endereco(String cep, String logradouro, String bairro, String localidade, String uf)  {


    @Override
    public String toString() {
        return "Endereco" +
                "CEP: " + cep + '\'' +
                "RUA: " + logradouro + '\'' +
                "BAIRRO: " + bairro + '\'' +
                "CIDADE: " + localidade + '\'' +
                "ESTADO/UF: " + uf + '\'';
    }
}
