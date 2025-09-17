package br.com.estudante.gestaoprojeto.repository;

import br.com.estudante.gestaoprojeto.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository //isso nao é obrigatorio, mas é interessante pois indica que é um componente do Spring

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {

    Optional<Aluno> findByEmail(String email);
}
