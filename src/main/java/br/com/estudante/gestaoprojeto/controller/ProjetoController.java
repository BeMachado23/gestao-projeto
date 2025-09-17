package br.com.estudante.gestaoprojeto.controller;


import br.com.estudante.gestaoprojeto.model.Aluno;
import br.com.estudante.gestaoprojeto.model.Projeto;
import br.com.estudante.gestaoprojeto.model.Tarefa;
import br.com.estudante.gestaoprojeto.repository.AlunoRepository;
import br.com.estudante.gestaoprojeto.repository.ProjetoRepository;
import br.com.estudante.gestaoprojeto.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController //indica ao Spring que essa classe vai gerenciar endpoints REST
@RequestMapping("/projeto")// Isso é pra definir o caminho para os endpoints nesta classe
public class ProjetoController {
    private final ProjetoRepository projetoRepository;
    private final AlunoRepository alunoRepository;
    private final TarefaRepository tarefaRepository;

    //injeção de dependencia para usar o repositorio
    public ProjetoController(ProjetoRepository projetoRepository, AlunoRepository alunoRepository, TarefaRepository tarefaRepository){
        this.projetoRepository = projetoRepository;
        this.alunoRepository = alunoRepository;
        this.tarefaRepository = tarefaRepository;
    }

    @PostMapping //mapeia o metodo para requisições HTTP POST
    public Projeto criarProjeto(@RequestBody Projeto projeto){ //Request Body vai salvar o seu JSON no corpo da requisição e converterá para um objeto "Projeto"
        return this.projetoRepository.save(projeto); //o repositório vai salvar ele no banco
    }

    // adicionar alunos a um projeto existente
    @PostMapping("/{projetoId}/alunos")
    public Projeto adicionarAlunosAoProjeto(@PathVariable UUID projetoId, @RequestBody List<UUID> alunosIds) {
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        List<Aluno> alunos = new ArrayList<>();
        alunoRepository.findAllById(alunosIds).forEach(alunos::add);

        if (alunos.isEmpty()) {
            throw new RuntimeException("Nenhum aluno encontrado para os IDs informados");
        }

        if (projeto.getAlunos() == null) {
            projeto.setAlunos(new ArrayList<>());
        }
        projeto.getAlunos().addAll(alunos);

        return projetoRepository.save(projeto);
    }
    @GetMapping
    public List<Projeto> listarProjetos(){
        return this.projetoRepository.findAll();
    }

    //Tarefa
    @PostMapping("/{projetoId}/tarefa")
    public ResponseEntity<Tarefa> criarTarefa(@PathVariable UUID projetoId, @RequestBody Tarefa tarefa){
        Projeto projeto = projetoRepository.findById(projetoId).orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        tarefa.setProjeto(projeto);
        Tarefa novaTarefa = tarefaRepository.save(tarefa);
        return ResponseEntity.status(201).body(novaTarefa);
    }
    @GetMapping("/{projetoId}/tarefa")
    public List<Tarefa> listarTarefasDoProjeto(@PathVariable UUID projetoId){
        return tarefaRepository.findByProjetoId(projetoId);
    }
}
