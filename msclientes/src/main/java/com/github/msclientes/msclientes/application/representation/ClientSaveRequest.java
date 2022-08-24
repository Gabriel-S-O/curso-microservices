package com.github.msclientes.msclientes.application.representation;

import com.github.msclientes.msclientes.domain.Cliente;
import lombok.Data;

@Data
public class ClientSaveRequest {

    private String nome;
    private Integer idade;
    private String cpf;

    public Cliente toModel(){
        return new Cliente(nome, idade, cpf);
    }
}
