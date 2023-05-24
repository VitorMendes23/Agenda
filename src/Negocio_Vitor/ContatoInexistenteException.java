package Negocio_Vitor;

public class ContatoInexistenteException extends Exception {

    public ContatoInexistenteException(String nome) {
        super("Não existe o contato '" + nome + "'  na agenda.");
    }



    @Override
    public String getMessage() {
        return super.getMessage() + " Certifique-se que o nome está correto e tente novamene.";
    }
}
