# Sistema de Cadastro de Ninjas 🥷

Bem-vindo ao **Sistema de Cadastro de Ninjas**!  
Este projeto é uma aplicação com arquitetura em camadas package by feature, desenvolvida com **Spring Boot**, criada para cadastrar **Ninjas** e suas respectivas **Missões**.

## ✅ Pré-requisitos

Antes de começar, garanta que você tenha instalado:

- **Java 17 ou superior**
- **Maven 3.x**
- **Git**
- (Opcional) **Docker** – caso queira testar com banco externo.

## ⚠️ Configuração de Variáveis de Ambiente (IMPORTANTE!)

O sistema está configurado para **buscar as credenciais de banco de dados a partir de variáveis de ambiente**.

### Variáveis obrigatórias:

| Variável | Exemplo de Valor |
|---|---|
| `DATABASE_URL` | `jdbc:h2:mem:cadastro_ninjas` |
| `DATABASE_USERNAME` | `sa` |
| `DATABASE_PASSWORD` | *(em branco para H2)* |

### Como configurar:

#### Em Linux ou MacOS:

```bash
export DATABASE_URL=jdbc:h2:mem:cadastro_ninjas
export DATABASE_USERNAME=sa
export DATABASE_PASSWORD=
```

Em Windows (PowerShell):
powershell

````bash
$env:DATABASE_URL="jdbc:h2:mem:cadastro_ninjas"
$env:DATABASE_USERNAME="sa"
$env:DATABASE_PASSWORD=""
````

### ✅  Configuração interna (application.properties)

````java
spring.application.name=CadastroDeNinjas

spring.h2.console.path=/h2-console
spring.h2.console.enabled=true

spring.datasource.driver=org.h2.Driver
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl

spring.flyway.enable=true
spring.flyway.locations=classpath:db/migrations
spring.flyway.baseline-on-migrate=true
````

### 🛠️ Tecnologias Utilizadas

- **Spring Boot**: Para criação da aplicação web e gerenciamento de dependências.
- **Banco de Dados H2**: Banco de dados em memória para desenvolvimento e testes.
- **Flyway**: Para gerenciamento de migrações do banco de dados.
- **JPA (Java Persistence API)**: Para mapeamento objeto-relacional (ORM).
- **Git**: Controle de versão para gerenciamento de mudanças no código.
- **GitHub**: Hospedagem do repositório para controle de versão.
- **Spring Data JPA**: Para interação com o banco de dados.
- **Maven**: Para build e gerenciamento de dependências do projeto.
- **SQL**: Manipulação do banco de dados

### 🗃️ Design do Banco de Dados
Entidades principais:

**Ninja**:
- id
- name
- age
- email
- rank
- special ability
- mission

**Missão**:

- id
- name
- rank
- ninjas


📌 **Relacionamento**:

    Um Ninja → Uma Missão

    Uma Missão → Muitos Ninjas

### 📂 Estrutura de Pacotes (Camadas)

- src/main/java/dev/seuusuario/cadastrodeninjas/

  - **Mission/**
      - **MissionController.java** - Controlador REST para Missões
      - **MissionDTO.java** - DTO para Missões
      - **MissionMapper.java** - Conversão de Missão para DTO
      - **MissionModel.java** - Entidade JPA para Missões
      - **MissionRank** - Enum para a dificuldade das missões
      - **MissionService.java** - Lógica de negócio para Missões
      - **MissionRepository.java** - Repositório JPA para Missões
    
  - **Ninja/**
    - **NinjaController.java** - Controlador REST para Ninjas
    - **NinjaDTO.java** - DTO para Ninjas
    - **NinjaMapper.java** - Conversão de Ninja para DTO
    - **NinjaModel.java** - Entidade JPA para Ninjas
    - **NinjaRank** - Enum para o rank do ninja
    - **NinjaService.java** - Lógica de negócio para Ninjas
    - **NinjaRepository.java** - Repositório JPA para Ninjas

  - **CadastroDeNinjasApplication.java** - Classe principal da aplicação

    
### ⚙️ Como Rodar Localmente


Clone o repositório:

```java

git clone https://github.com/DANR1BEIRO/Ninja-Registration.git
```

Acesse o diretório do projeto:

```java

cd Ninja-Registration
```

Configure as variáveis de ambiente:

(Exemplo para rodar com H2)

````java
export DATABASE_URL=jdbc:h2:mem:cadastro_ninjas
export DATABASE_USERNAME=sa
export DATABASE_PASSWORD=
````
Compile o projeto com Maven:
```java
mvn clean install
```

Execute a aplicação:

```java
mvn spring-boot:run
```

Acesse a aplicação no navegador:

http://localhost:8080

Acesse o console H2 (opcional):

http://localhost:8080/h2-console
