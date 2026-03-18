package com.javanauta.usuario.infrastructure.exceptions;

//Verificação de questões de conflito

public class ConflictException extends RuntimeException{
    // Construtor de uma exceção não verificada
    public ConflictException(String mensagem){

        super(mensagem);
    }

    public ConflictException(String mensagem, Throwable throwable){

        super(mensagem);
    }
}
