package MetodosRapidos;

import Records.Endereco;


public class Validadores {

    public boolean tamanhoCep(String e){
        if(e.length() == 8){
            return true;
        }
        return false;
    }

    public boolean cepInvalido(Endereco end){

        if(end.cep() == null){

            return false;
        }
        return true;
    }
}
