# API de Gestão de Projetos de Estudantes

## Descrição

Esta é uma API RESTful desenvolvida em Java com Spring Boot para gerenciar projetos de estudantes. A aplicação permite o cadastro de alunos e projetos, a criação de tarefas dentro desses projetos, e o registro e avaliação de entregas.

Este projeto foi construído como parte de um exercício de aprendizado, focando em boas práticas de design de APIs REST, persistência de dados com JPA/Hibernate e uma arquitetura em camadas.

## Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**: Framework principal para a construção da API.
- **Spring Data JPA**: Para persistência de dados e comunicação com o banco.
- **H2 Database**: Banco de dados em memória para ambiente de desenvolvimento.
- **Maven**: Gerenciador de dependências e build do projeto.
- **Lombok**: Para reduzir código boilerplate nas classes de modelo.

## Como Executar

1. Clone o repositório para sua máquina local.
2. Abra o projeto com o IntelliJ IDEA.
3. O Maven irá baixar todas as dependências necessárias automaticamente.
4. Encontre a classe `GestaoProjetosApplication.java` e execute o método `main`.
5. O servidor iniciará na porta `8080`. A API estará pronta para receber requisições em `http://localhost:8080`.

## Endpoints da API

Abaixo está a lista de todos os endpoints REST implementados:

| Método | Path | Descrição |
| :--- | :--- | :--- |
| `POST` | `/aluno` | Cria um novo aluno. |
| `POST` | `/projeto` | Cria um novo projeto. |
| `GET` | `/projeto` | Lista todos os projetos cadastrados. |
| `POST` | `/projeto/{projetoId}/alunos` | Associa um ou mais alunos (por ID) a um projeto. |
| `DELETE`| `/projeto/{projetoId}/alunos/{alunoId}`| Remove a associação de um aluno com um projeto. |
| `POST` | `/projeto/{projetoId}/tarefa` | Cria uma nova tarefa dentro de um projeto. |
| `GET` | `/projeto/{projetoId}/tarefa` | Lista as tarefas de um projeto (filtro opcional: `?status=...`). |
| `POST` | `/entrega` | Registra uma nova entrega de um aluno para uma tarefa. |
| `GET` | `/entrega` | Lista as entregas de uma tarefa (filtro: `?tarefaId=...`). |
| `PATCH`| `/entrega/{entregaId}/avaliar` | Adiciona uma nota a uma entrega existente. |
