# Customer API

[![Status da Build](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/fabriciosaand/customerwiremock/actions)
[![Cobertura de Testes](https://img.shields.io/badge/coverage-85%25-yellowgreen)](https://github.com/fabriciosaand/customerwiremock)
[![Licença: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

Uma API RESTful para gerenciamento de clientes, construída com Spring Boot.

## Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Começando](#começando)
    - [Pré-requisitos](#pré-requisitos)
    - [Instalação e Execução](#instalação-e-execução)
- [Executando os Testes](#executando-os-testes)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Sobre o Projeto

Este projeto consiste em uma API RESTful para realizar operações de CRUD (Criar, Ler, Atualizar e Deletar) de clientes. O objetivo é fornecer um serviço robusto, escalável e de fácil integração para sistemas que necessitam gerenciar informações de clientes.

A API foi desenvolvida seguindo as melhores práticas de arquitetura de software, incluindo separação de responsabilidades em camadas (Controller, Service, Repository).

**Principais Funcionalidades:**
- Criação de novos clientes.
- Busca de clientes por ID.
- Listagem de todos os clientes cadastrados.
- Atualização de informações de um cliente existente.
- Remoção de um cliente.

## Tecnologias Utilizadas

Abaixo estão as principais tecnologias e ferramentas utilizadas no desenvolvimento da API:

- **Backend:**
    - [Java 17+](https://www.oracle.com/java/)
    - [Spring Boot](https://spring.io/projects/spring-boot)
    - [Spring Web](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
    - [Maven](https://maven.apache.org/)
- **Testes:**
    - [JUnit 5](https://junit.org/junit5/)
    - [Mockito](https://site.mockito.org/)
- **DevOps:**
    - [GitHub Actions](https://github.com/features/actions) (placeholder)
    - [Docker](https://www.docker.com/) (placeholder)

## Começando

Para executar o projeto localmente, siga os passos abaixo.

### Pré-requisitos

Antes de começar, certifique-se de que você tem o seguinte software instalado:
- [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/downloads/) v17 ou superior.
- [Apache Maven](https://maven.apache.org/download.cgi) v3.8+.

### Instalação e Execução

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/fabriciosaand/customerwiremock
    ```

2.  **Navegue para o diretório do projeto:**
    ```bash
    cd customer-api
    ```

3.  **Instale as dependências:**
    O Maven fará o download das dependências automaticamente. Para garantir que tudo está correto, você pode compilar o projeto:
    ```bash
    mvn clean install
    ```

4.  **Configure as variáveis de ambiente (se aplicável):**
    As configurações da aplicação, como a conexão com o banco de dados, estão no arquivo `src/main/resources/application.properties`. Ajuste-o conforme necessário para o seu ambiente.

5.  **Inicie o servidor de desenvolvimento:**
    ```bash
    mvn spring-boot:run
    ```
    A API estará disponível em `http://localhost:8080`.

## Executando os Testes

Para rodar a suíte de testes automatizados e garantir a integridade do código, execute o seguinte comando na raiz do projeto:

```bash
mvn test
```

## Análise de Cobertura de Testes

Para garantir a qualidade e a robustez do código, o projeto está configurado com o JaCoCo, uma ferramenta para análise de cobertura de testes. A configuração atual exige uma cobertura mínima de 85% para as instruções do código.

Para gerar o relatório de cobertura localmente, execute o seguinte comando na raiz do projeto:

```bash
mvn clean verify
```

Este comando irá compilar o código, executar os testes e gerar o relatório de cobertura. Se a cobertura for inferior a 85%, o build falhará.

Após a execução bem-sucedida, o relatório HTML pode ser acessado no seguinte caminho:

`target/site/jacoco/index.html`

Abra este arquivo em seu navegador para visualizar os detalhes da cobertura de cada classe e método.

## Contribuição

Contribuições são o que tornam a comunidade de código aberto um lugar incrível para aprender, inspirar e criar. Qualquer contribuição que você fizer será **muito apreciada**.

Se você tem uma sugestão para melhorar este projeto, por favor, faça um fork do repositório e crie uma pull request. Você também pode simplesmente abrir uma issue com a tag "enhancement".

Não se esqueça de dar uma estrela ao projeto! Obrigado novamente!

1.  Faça um Fork do projeto
2.  Crie sua Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Faça o Commit de suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4.  Faça o Push para a Branch (`git push origin feature/AmazingFeature`)
5.  Abra uma Pull Request

## Licença

Distribuído sob a Licença MIT. Veja `LICENSE.txt` para mais informações.