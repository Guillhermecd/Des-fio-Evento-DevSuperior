# Sistema de Gerenciamento de Eventos (EVENTO)

Sistema desenvolvido em Spring Boot para gerenciar participantes e atividades de um evento acadêmico.

## Requisitos

- Java 17+
- Maven 3.6+

## Estrutura do Projeto

```
evento/
├── src/
│   ├── main/
│   │   ├── java/com/devsuperior/evento/
│   │   │   ├── entities/           # Classes de domínio
│   │   │   ├── repositories/       # Interfaces de persistência
│   │   │   ├── config/             # Configurações
│   │   │   └── EventoApplication.java  # Classe principal
│   │   └── resources/
│   │       └── application.properties  # Configurações da aplicação
│   └── test/
├── pom.xml                         # Dependências Maven
└── README.md
```

## Entidades

### Categoria
- **id**: Identificador único
- **descricao**: Descrição da categoria (Ex: Curso, Oficina)

### Atividade
- **id**: Identificador único
- **nome**: Nome da atividade
- **descricao**: Descrição detalhada
- **preco**: Preço da atividade
- **categoria**: Referência para Categoria (muitos-para-um)
- **blocos**: Coleção de Blocos (um-para-muitos)
- **participantes**: Coleção de Participantes (muitos-para-muitos)

### Participante
- **id**: Identificador único
- **nome**: Nome do participante
- **email**: Email do participante
- **atividades**: Coleção de Atividades (muitos-para-muitos)

### Bloco
- **id**: Identificador único
- **inicio**: Data/Hora de início (Instant)
- **fim**: Data/Hora de fim (Instant)
- **atividade**: Referência para Atividade (muitos-para-um)

## Dados de Seeding

O projeto inclui dados de exemplo que são carregados automaticamente ao iniciar a aplicação:

### Categorias
- Curso
- Oficina

### Atividades
1. **Curso de HTML** - Aprenda HTML de forma prática (R$ 80.00)
2. **Oficina de Github** - Controle versões de seus projetos (R$ 50.00)

### Participantes
1. José Silva (jose@gmail.com)
2. Tiago Faria (tiago@gmail.com)
3. Maria do Rosário (maria@gmail.com)
4. Teresa Silva (teresa@gmail.com)

### Blocos
1. 25/09/2017 08:00 às 11:00 - Curso de HTML
2. 25/09/2017 14:00 às 18:00 - Oficina de Github
3. 26/09/2017 08:00 às 11:00 - Oficina de Github

## Como Executar

### 1. Clonar o repositório
```bash
git clone <url-do-repositorio>
cd evento
```

### 2. Compilar o projeto
```bash
mvn clean install
```

### 3. Executar a aplicação
```bash
mvn spring-boot:run
```

### 4. Acessar o H2 Console
Após iniciar a aplicação, acesse:
- **URL**: http://localhost:8080/h2-console
- **Driver Class**: org.h2.Driver
- **JDBC URL**: jdbc:h2:mem:testdb
- **User Name**: sa
- **Password**: (deixar em branco)

## Banco de Dados

O projeto utiliza:
- **Banco**: H2 (em memória)
- **ORM**: JPA/Hibernate
- **Pool de Conexões**: HikariCP (padrão do Spring Boot)

### Configurações (application.properties)
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
```

## Tabelas Criadas

O Hibernate criará automaticamente as seguintes tabelas:
- `tb_categoria`
- `tb_participante`
- `tb_atividade`
- `tb_bloco`
- `tb_participante_atividade` (tabela de associação)

## Tecnologias Utilizadas

- **Spring Boot 3.1.5**
- **Spring Data JPA**
- **Hibernate**
- **H2 Database**
- **Maven**
- **Java 17**

## Autor

Desenvolvido como desafio DevSuperior - Formação Desenvolvedor Moderno

## Licença

Este projeto é de uso educacional.
