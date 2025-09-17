package br.com.estudante.gestaoprojeto.controller;

import br.com.estudante.gestaoprojeto.dto.AvaliacaoRequestDTO;
import br.com.estudante.gestaoprojeto.dto.EntregaRequestDTO;
import br.com.estudante.gestaoprojeto.model.Aluno;
import br.com.estudante.gestaoprojeto.model.Entrega;
import br.com.estudante.gestaoprojeto.model.Tarefa;
import br.com.estudante.gestaoprojeto.repository.AlunoRepository;
import br.com.estudante.gestaoprojeto.repository.EntregaRepository;
import br.com.estudante.gestaoprojeto.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
    private final EntregaRepository entregaRepository;
    private final AlunoRepository alunoRepository;
    private final TarefaRepository tarefaRepository;

    public EntregaController(EntregaRepository entregaRepository, AlunoRepository alunoRepository, TarefaRepository tarefaRepository) {
        this.entregaRepository = entregaRepository;
        this.alunoRepository = alunoRepository;
        this.tarefaRepository = tarefaRepository;
    }

    @PostMapping
    public ResponseEntity<Entrega> criarEntrega(@RequestBody EntregaRequestDTO dto){
        Tarefa tarefa = tarefaRepository.findById(dto.tarefaId()).orElseThrow(()-> new RuntimeException("Tarefa nao encontrada"));
        Aluno aluno = alunoRepository.findById(dto.alunoId()).orElseThrow(()-> new RuntimeException("Aluno nao encontrado"));

        Entrega novaEntrega = new Entrega();
        novaEntrega.setTarefa(tarefa);
        novaEntrega.setAluno(aluno);
        novaEntrega.setUrl(dto.url());

        Entrega entregaSalva = entregaRepository.save(novaEntrega);
        return ResponseEntity.status(201).body(entregaSalva);
    }

    @GetMapping
    public List<Entrega> listarEntregas(@RequestParam UUID tarefaId){
        return entregaRepository.findByTarefaId(tarefaId);
    }
    @PatchMapping("/{entregaId}/avaliar")
    public Entrega avaliarEntrega(@PathVariable UUID entregaId, @RequestBody AvaliacaoRequestDTO dto){
        Entrega entrega = entregaRepository.findById(entregaId).orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
        entrega.setNota(dto.nota());
        return entregaRepository.save(entrega);
    }
}
