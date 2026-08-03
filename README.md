# Sistema Bancário em Java

Projeto educacional de linha de comando para praticar orientação a objetos, regras bancárias, exceções e persistência em arquivo.

> **Status:** projeto de estudo em revisão. A estrutura principal está presente, mas alguns pontos ainda precisam ser reconciliados antes de uma versão estável.

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
- Uma IDE Java ou o compilador `javac`

O projeto ainda não possui Maven ou Gradle. A execução é feita a partir de `src/Main.java` após a compilação das classes do diretório `src/`.

## Dados de exemplo

O arquivo `contas.txt` contém apenas registros fictícios usados para testar a persistência local. Não utilize dados pessoais ou financeiros reais neste projeto.

## Próximos passos

- Corrigir inconsistências entre o menu e a camada de serviço
- Remover arquivos compilados do versionamento
- Adicionar `.gitignore` para arquivos da IDE e de build
- Adotar Maven ou Gradle
- Criar testes para depósitos, saques e transferências
- Substituir `double` por `BigDecimal` para representar valores monetários

## Aviso

Este é um projeto exclusivamente educacional. Ele não implementa requisitos de segurança, auditoria ou precisão necessários para sistemas financeiros reais.

