# SIGAI

API REST para gerenciamento de imóveis e suas fotos, desenvolvida durante as aulas de **Desenvolvimento de Sistemas Corporativos**, no 6º período do curso de Tecnologia em Análise e Desenvolvimento de Sistemas (TADS).

## Tecnologias

- Java
- Spring Boot
- Spring Security
- JWT (autenticação e autorização)
- PostgreSQL
- Maven

## Funcionalidades

- Autenticação de usuários com JWT.
- Cadastro, consulta, atualização, exclusão e filtragem de imóveis.
- Cadastro, consulta, atualização e exclusão de fotos dos imóveis.
- Controle de acesso baseado em perfis de usuário.

## Configuração do projeto

### 1. Crie o banco de dados

Antes de executar a aplicação, crie um banco de dados PostgreSQL:

```sql
CREATE DATABASE db_sigai;
```

### 2. Configure as variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto, utilizando o `.env.example` como referência.

Configure as seguintes variáveis:

```env
DB_URL=jdbc:postgresql://localhost:5432/db_sigai
DB_USERNAME=postgres
DB_PASSWORD=sua_senha

JWT_SECRET=sua_chave_secreta_com_no_minimo_32_caracteres
```

Substitua os valores pelos dados do seu ambiente local.

### 3. Execute a aplicação

Com o PostgreSQL em execução e as variáveis configuradas, execute o projeto pela sua IDE.

A API estará disponível em `http://localhost:8080`, considerando a porta padrão.

## Endpoints

### Autenticação

| Método | Endpoint | Descrição | Acesso |
|---|---|---|---|
| POST | `/auth/login` | Autenticar usuário e obter token JWT | Público |

### Imóveis

| Método | Endpoint | Descrição | Acesso |
|---|---|---|---|
| POST | `/imoveis` | Cadastrar imóvel | ADMIN |
| GET | `/imoveis` | Listar imóveis | Autenticado |
| GET | `/imoveis/{id}` | Buscar imóvel por ID | Autenticado |
| GET | `/imoveis/filtrar` | Filtrar por endereço e valor máximo | Autenticado |
| PUT | `/imoveis/{id}` | Atualizar imóvel | ADMIN |
| DELETE | `/imoveis/{id}` | Excluir imóvel | ADMIN |

### Fotos

| Método | Endpoint | Descrição | Acesso |
|---|---|---|---|
| POST | `/fotos` | Cadastrar foto | ADMIN |
| GET | `/fotos` | Listar fotos | Autenticado |
| GET | `/fotos/{id}` | Buscar foto por ID | Autenticado |
| PUT | `/fotos/{id}` | Atualizar foto | ADMIN |
| DELETE | `/fotos/{id}` | Excluir foto | ADMIN |

## Como testar

Os endpoints podem ser testados utilizando o Postman.

### 1. Autenticação

Envie uma requisição `POST` para:

`http://localhost:8080/auth/login`

Corpo da requisição:

```json
{
  "username": "admin",
  "password": "admin123"
}
```

A resposta conterá o token JWT.

### 2. Utilize o token

Nas requisições protegidas, acesse a aba **Authorization** do Postman, selecione **Bearer Token** e informe o token recebido no login.

### 3. Teste os endpoints

Utilize os métodos HTTP e as rotas documentadas acima. Para cadastrar ou atualizar imóveis, envie um JSON com os campos `endereco`, `valorAluguel` e `descricao`.

Para cadastrar ou atualizar fotos, utilize os campos definidos no `FotoRequestDTO`.

### 4. Teste as permissões

O projeto possui três perfis de usuário:

- **ADMIN:** pode cadastrar, atualizar e excluir imóveis e fotos.
- **CORRETOR:** pode consultar imóveis; operações de escrita são restritas.
- **CLIENTE:** pode consultar imóveis; operações de escrita são restritas.

As rotas protegidas exigem autenticação.

As credenciais acima são exemplos para ambiente de desenvolvimento. Verifique os usuários cadastrados no banco antes de realizar os testes.

## Autor

Projeto acadêmico desenvolvido no 6º período do curso de Tecnologia em Análise e Desenvolvimento de Sistemas (TADS), na disciplina de Desenvolvimento de Sistemas Corporativos.
