package br.com.estudante.gestaoprojeto.repository;

import br.com.estudante.gestaoprojeto.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {

    List<Tarefa> findByProjetoId(UUID projetoId);
    /*
      pelo que eu entendi o Spring Data JPA é inteligente. Ao ler um método
      chamado findByProjetoId, ele automaticamente entende que deve
      procurar na entidade Tarefa por um campo chamado projeto e filtrar
      pelo id desse projeto. Não precisamos escrever a consulta SQL.
   */
}
