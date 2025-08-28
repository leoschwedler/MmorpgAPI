# ⚔️ Sistema de MMORPG

Bem-vindo ao **Sistema de MMORPG**!  
Este projeto é uma aplicação em **arquitetura em camadas**, desenvolvida com **Spring Boot**, projetada para gerenciar **personagens (Characters)**, seus **itens (Items)** e **guildas (Guilds)**.  

O projeto utiliza **MySQL** (ou **H2** para testes) como banco de dados, segue boas práticas de desenvolvimento como **DTO + Mapper Pattern**, uso de **ResponseEntity** em todos os endpoints e **controle de versão com Git/GitHub**.  

---

## 📖 Visão Geral do Projeto

Este sistema foi desenvolvido para **gerenciar personagens, itens e guildas** em um MMORPG.  
Cada entidade possui relacionamentos definidos para refletir a estrutura do jogo.

### Funcionalidades
- 📌 Cadastro e gerenciamento de **personagens** com atributos como `nome`, `level` e associação a uma **guilda**.  
- 📌 Cadastro de **itens** que podem ser atribuídos a personagens.  
- 📌 Gerenciamento de **guildas**, que agrupam vários personagens.  
- 📌 Endpoints RESTful estruturados, utilizando **ResponseEntity** para respostas HTTP claras.  

---

## 🛠 Tecnologias Utilizadas

| Tecnologia | Descrição |
|------------|-----------|
| **Spring Boot** | Criação da aplicação web e gerenciamento de dependências |
| **Spring Data JPA (Hibernate)** | Mapeamento objeto-relacional (ORM) |
| **MySQL / H2** | Banco de dados relacional (MySQL em produção, H2 para testes) |
| **Lombok** | Redução de boilerplate com anotações (`@Data`, `@AllArgsConstructor`, etc.) |
| **Maven** | Build e gerenciamento de dependências |
| **DTO + Mapper Pattern** | Separação de entidades e transporte de dados |
| **ResponseEntity** | Controle de respostas HTTP nos endpoints |
| **Git & GitHub** | Controle de versão e hospedagem do código |

---

## 🗄 Design do Banco de Dados

**Entidades e Relacionamentos:**

- **Guild**
  - `id` (Long)
  - `name` (String)
  - 🔗 Relacionamento: **Um para Muitos** com `Character`

- **Character**
  - `id` (Long)
  - `name` (String)
  - `level` (Integer)
  - 🔗 Relacionamentos:  
    - **Muitos para Um** com `Guild`  
    - **Um para Muitos** com `Item`

- **Item**
  - `id` (Long)
  - `name` (String)
  - `type` (String)
  - `damage` (Integer)
  - 🔗 Relacionamento: **Muitos para Um** com `Character`

📌 **Regras principais**:  
- Uma **Guild** → pode ter vários **Characters**.  
- Um **Character** → pertence a apenas uma **Guild**, mas pode ter vários **Items**.  
- Um **Item** → pertence a apenas um **Character**.  

---

## 🌐 Endpoints Principais

### Character
- `POST /character/create` → Criar personagem  
- `GET /character/all` → Listar todos os personagens  
- `GET /character/showCharacterById/{id}` → Buscar personagem por ID  
- `PUT /character/updateCharacterById/{id}` → Atualizar personagem  
- `DELETE /character/deleteCharacterById/{id}` → Deletar personagem  

### Item
- `POST /item/create` → Criar item e associar a um personagem  
- `GET /item/all` → Listar todos os itens  
- `GET /item/showItemById/{id}` → Buscar item por ID  
- `PUT /item/updateItemById/{id}` → Atualizar item  
- `DELETE /item/deleteItemById/{id}` → Deletar item  

### Guild
- `POST /guild/create` → Criar guilda  
- `GET /guild/all` → Listar todas as guildas  
- `GET /guild/showGuildById/{id}` → Buscar guilda por ID  
- `PUT /guild/updateGuildById/{id}` → Atualizar guilda  
- `DELETE /guild/deleteGuildById/{id}` → Deletar guilda  

---

## 📐 Respostas HTTP (ResponseEntity)

Uso padronizado de `ResponseEntity` em todos os controllers:

| Status | Uso |
|--------|-----|
| `200 OK` | Sucesso em GET/PUT/DELETE com corpo |
| `201 Created` | Recurso criado (POST) |
| `204 No Content` | Operação bem-sucedida sem corpo (ex.: DELETE) |
| `400 Bad Request` | Validação/entrada inválida |
| `404 Not Found` | Recurso não encontrado |

Boas práticas:
- Definir explicitamente `HttpStatus` quando não for `200 OK`.  
- Evitar retornar `null` no body; retornar mensagem ou objeto de erro.  
- Lógica de validação e verificação deve ficar no **Service**; o **Controller** apenas formata a resposta.

---

## ⚙️ Configuração e Execução

### Pré-requisitos
- Java 17+
- Maven 3.8+
- MySQL (ou Docker com MySQL)
- Postman/Insomnia para testes dos endpoints

### Passos para rodar o projeto
```bash
# Clonar o repositório
git clone https://github.com/leoschwedler/mmorpg-springboot

# Entrar no diretório do projeto
cd mmorpg-springboot

# Compilar o projeto
mvn clean install

# Executar a aplicação
mvn spring-boot:run
