package br.com.estudante.gestaoprojeto.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Projeto {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String titulo;

    private String descricao;

    @CreationTimestamp // marca o tempo para ser preenchido com a data/hora da criação
    private LocalDateTime criadoEm;

    @ManyToMany
    @JoinTable(
            name = "projeto_aluno", // nome da tabela intermediaria que ligará projetos e aluno
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<Aluno> alunos;
}
