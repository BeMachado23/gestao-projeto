package br.com.estudante.gestaoprojeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data // anotacao do lombok para criar getters, setters, toString
@Entity // diz ao JPA que esta classe é uma tabela no banco de dados

public class Aluno {

    @Id // marca o campo como chave primaria da tabela
    @GeneratedValue(strategy = GenerationType.AUTO) // gera o valor do ID automaticamente
    private UUID id;

    @Column(nullable = false) //define que a coluna 'nome' nao possa ser nula
    private String nome;

    @Column(nullable = false, unique = true) //deve ser unico
    private String email;
}
