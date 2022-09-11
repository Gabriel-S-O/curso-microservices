package com.github.msavaliadorcredito.application.exceptions;

public class ClientDataNotFoundException extends Exception{

    public ClientDataNotFoundException() {
        super("Não foram encontrados dados do cliente com o cpf informado");
    }
}
