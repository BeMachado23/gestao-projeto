package br.com.estudante.gestaoprojeto.dto;

import java.util.UUID;

public record EntregaRequestDTO (String url, UUID tarefaId, UUID alunoId) {

}
