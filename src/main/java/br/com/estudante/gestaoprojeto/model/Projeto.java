package br.com.estudante.gestaoprojeto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Projeto {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column (nullable = false)
    private String Aluno;
}
