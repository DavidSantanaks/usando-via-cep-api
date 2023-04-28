package MetodosRapidos;

import Records.Endereco;

public class Validadores {


    public boolean validadores(Endereco e){

        if (e.cep() == null || e.cep().length() < 8 || e.cep().length() > 9){
            return false;
        }else{
            return true;
        }

    }

}
