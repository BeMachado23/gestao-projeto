package br.com.estudante.gestaoprojeto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "projeto_id", nullable = false) //chave estrangeira para a tabela projeto
    private Projeto projeto;

    @Column(nullable = false)
    private String titulo;
    private String descricao;

    @Column(nullable = false)
    private LocalDate prazo;

    @Enumerated(EnumType.STRING) // Diz ao JPA para salvar o nome do enum (ex: "TODO") em vez de um número
    @Column(nullable = false)
    private Status status;
}
