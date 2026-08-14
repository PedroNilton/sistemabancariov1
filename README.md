# Sistema Bancário em Java

[![Java CI](https://github.com/PedroNilton/sistemabancariov1/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/PedroNilton/sistemabancariov1/actions/workflows/ci.yml)

Projeto educacional de linha de comando para praticar orientação a objetos, regras bancárias, exceções e persistência em arquivo.

> **Status:** projeto educacional funcional, com build Maven e testes das operações bancárias principais.

## Funcionalidades planejadas

- Criação de contas
- Depósitos e saques
- Transferências entre contas
- Consulta de extrato
- Validação de saldo e contas inexistentes
- Persistência local dos dados em arquivo

## Conceitos praticados

- Encapsulamento e herança
- Separação entre model, repository e service
- Exceções específicas de domínio
- Coleções e Streams
- Persistência simples em arquivo texto
- Interface de linha de comando

## Estrutura

```text
src/
├── exception/    # Exceções do domínio
├── model/        # Cliente, conta e transações
├── repository/   # Carregamento e persistência das contas
├── service/      # Operações bancárias
└── Main.java     # Menu da aplicação
```

## Como executar

### Pré-requisitos

- JDK 17 ou superior
- Maven 3.9 ou superior

Na raiz do repositório, compile e execute os testes:

```bash
mvn clean verify
```

Depois, execute o menu de linha de comando:

```bash
java -cp target/classes Main
```

## Dados de exemplo

O arquivo `contas.txt` contém apenas registros fictícios usados para testar a persistência local. Não utilize dados pessoais ou financeiros reais neste projeto.

## Próximos passos

- Ampliar os testes para persistência e leitura de dados
- Substituir `double` por `BigDecimal` para representar valores monetários

## Aviso

Este é um projeto exclusivamente educacional. Ele não implementa requisitos de segurança, auditoria ou precisão necessários para sistemas financeiros reais.

