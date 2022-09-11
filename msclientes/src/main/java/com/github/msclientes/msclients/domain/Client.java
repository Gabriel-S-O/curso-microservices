package com.github.msclientes.msclients.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private String cpf;

    public Client(String name, Integer age, String cpf) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
    }
}
