package modelo;

import record.CepRecord;

public class CepModelo {
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    public CepModelo(CepRecord cepRecord){
        this.cep = cepRecord.cep();
        this.rua = cepRecord.logradouro();
        this.bairro = cepRecord.bairro();
        this.cidade = cepRecord.localidade();
        this.estado = cepRecord.uf();
    }

    @Override
    public String toString() {
        return "Dados do CEP informado: " +
                "CEP: " + this.cep + " " +
                "RUA: " + this.rua + " " +
                "BAIRRO: " + this.bairro + " " +
                "CIDADE: " + this.cidade + " " +
                "ESTADO: " + this.estado + " ";
    }
}
