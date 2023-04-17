# Spring Boot 3: desenvolvendo uma API Rest em Java

Este é um projeto Java com Spring Boot 3 que está sendo desenvolvido durante o curso "Spring Boot 3: desenvolva uma API Rest em Java" da Alura.

## Descrição do projeto

O objetivo deste projeto é desenvolver uma API Rest em Java utilizando o Spring Boot 3. A API permitirá a criação, leitura, atualização e exclusão de informações de produtos.

O projeto também utilizará o banco de dados MySQL para armazenamento de dados, o Flyway como ferramenta de migrations da API, o Bean Validation para validação de dados e a paginação dos dados da API.

## Como executar o projeto

Para executar o projeto, é necessário ter o JDK 17 e o Maven instalados em sua máquina.

1. Clone este repositório em sua máquina:
   `git clone https://github.com/viavn/vollmedapi.git`

2. Acesse o diretório do projeto:
   `cd api`

3. Execute o seguinte comando para subir o container MySQL:
   `docker-compose up -d`

4. Execute o projeto com o seguinte comando:
   `mvn spring-boot:run`

5. Acesse o endereço http://localhost:8080/swagger-ui.html para visualizar a documentação da API gerada automaticamente pelo Swagger.

## Tecnologias utilizadas

- Java 17
- Spring Boot 3
- MySQL
- Flyway
- Bean Validation
- Spring Data JPA
- Maven
- Swagger
- Docker

## Licença

Este projeto está sob a licença MIT. Consulte o arquivo LICENSE para obter mais informações.
