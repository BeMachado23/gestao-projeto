package br.com.estudante.gestaoprojeto.controller;

import br.com.estudante.gestaoprojeto.model.Aluno;
import br.com.estudante.gestaoprojeto.repository.AlunoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    private final AlunoRepository alunoRepository;

    public AlunosController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }
    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno){
        if (alunoRepository.findByEmail(aluno.getEmail()).isPresent()){
            throw new RuntimeException("Email já cadastrado");
        }
        return alunoRepository.save(aluno);
    }
}
