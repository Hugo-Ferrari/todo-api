#  Todo API

API REST para gerenciamento de tarefas desenvolvida com Java e Spring Boot.

##  Tecnologias

- Java 17
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA
- H2 Database
- Swagger (OpenAPI 3)
- Maven
- Lombok

##  Funcionalidades

- Cadastro e login de usuários
- Autenticação com JWT
- CRUD completo de tarefas
- Cada usuário acessa apenas suas próprias tarefas
- Documentação automática com Swagger

##  Como rodar localmente

### Pré-requisitos
- Java 17+
- Maven

### Passos
1. Clone o repositório
   git clone https://github.com/seuusuario/todo-api.git

2. Entre na pasta
   cd todo-api

3. Rode o projeto
   ./mvnw spring-boot:run

4. Acesse a documentação
   http://localhost:8080/swagger-ui/index.html

##  Como usar a API

### 1. Cadastre um usuário
POST /user/auth/register
{
"username": "seu nome",
"password": "sua senha",
"email": "seu email"
}

### 2. Faça login e copie o token
POST /user/auth/login
{
"username": "seu nome",
"password": "sua senha "
}

### 3. Use o token nas requisições
Header: Authorization: Bearer {token}

### 4. Crie uma tarefa
POST /tasks
{
"title": "Minha tarefa",
"description": "Descrição",
"status": "PENDENTE",
"user": { "id": 1 }
}

##  Documentação completa
Acesse o Swagger em: http://localhost:8080/swagger-ui/index.html

##  Autor
Hugo Ferrari - [LinkedIn](https://www.linkedin.com/in/hugoferraripires/) - [GitHub](https://github.com/Hugo-Ferrari)
