package br.com.treinamento.restapi.services.exception;

public class AutorNaoEncontradoException extends RuntimeException {

    public AutorNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public AutorNaoEncontradoException(String mensagem, Throwable causa){
        super(mensagem,causa);
    }

}
