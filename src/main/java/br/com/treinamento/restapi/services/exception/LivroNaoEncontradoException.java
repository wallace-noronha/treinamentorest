package br.com.treinamento.restapi.services.exception;

public class LivroNaoEncontradoException extends RuntimeException {

    public LivroNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public LivroNaoEncontradoException(String mensagem, Throwable causa){
        super(mensagem,causa);
    }

}
