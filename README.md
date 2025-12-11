# 📦 Estoque API - Sistema de Gerenciamento de Ativos

> Status do Projeto: 🚀 Concluído (Backend)

### 📖 Sobre
API RESTful desenvolvida para gerenciamento de estoque e ativos. O projeto foi criado com o objetivo de aplicar conceitos sólidos de **Engenharia de Software**, focando em uma arquitetura limpa, escalável e conectada a um banco de dados real.

A ideia nasceu da necessidade de organizar equipamentos (hardware, áudio, etc.), permitindo cadastro e consulta de forma rápida e padronizada.

---

### 🛠 Tecnologias Utilizadas

* **Java 21** (Linguagem Core)
* **Spring Boot 3** (Framework Principal)
* **Spring Data JPA** (Persistência e ORM)
* **MySQL** (Banco de Dados Relacional)
* **Maven** (Gerenciamento de Dependências)
* **Postman/cURL** (Testes de API)

---

### ⚙️ Arquitetura do Projeto

O projeto segue a arquitetura **MVC (Model-View-Controller)** adaptada para API REST, garantindo a separação de responsabilidades:

1.  **Controller (`ItemController`)**:
    * A "Porta de Entrada" da API.
    * Recebe as requisições HTTP (GET/POST) e decide para onde mandar.
    * Exposto na rota: `/itens`.

2.  **Model (`Item`)**:
    * O "Molde" dos dados.
    * Mapeia a classe Java diretamente para a tabela `tb_itens` no banco de dados usando anotações JPA (`@Entity`).

3.  **Repository (`ItemRepository`)**:
    * O "Estoquista".
    * Interface responsável por toda a comunicação com o MySQL.
    * Abstrai comandos SQL complexos através do `JpaRepository`.

---

### 🔌 Endpoints da API

| Método | Rota | Descrição | Exemplo de JSON (Body) |
| :--- | :--- | :--- | :--- |
| **GET** | `/itens` | Lista todos os itens do banco | *N/A* |
| **POST** | `/itens` | Cadastra um novo item | `{"nome": "Cabo XLR", "categoria": "AUDIO", "quantidade": 10}` |

---

### 🚀 Como rodar o projeto na sua máquina

#### Pré-requisitos
* Java 17 ou superior.
* MySQL instalado e rodando.
* Maven.

#### Passo a passo
1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/pauloaviila/estoque-api.git](https://github.com/pauloaviila/estoque-api.git)
    ```
2.  **Configure o Banco de Dados:**
    * Crie um banco no MySQL chamado `sistema_estoque`.
    * No arquivo `src/main/resources/application.properties`, altere o `username` e `password` para o seu MySQL local.
3.  **Execute o projeto:**
    * Abra o terminal na pasta raiz e rode: `mvn spring-boot:run`
    * Ou execute pela sua IDE (Eclipse/IntelliJ).

---

### 👨‍💻 Autor

Desenvolvido por **Paulo Avila**.
* Estudante de Engenharia de Software
* Music Producer & Tech Enthusiast

---
