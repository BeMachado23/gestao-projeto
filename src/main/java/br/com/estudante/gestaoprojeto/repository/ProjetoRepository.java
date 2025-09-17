package br.com.estudante.gestaoprojeto.repository;

import br.com.estudante.gestaoprojeto.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, UUID> {

}
