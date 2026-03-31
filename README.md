# Processador de Contatos em Java

Projeto desenvolvido em Java puro com o objetivo de praticar fundamentos importantes para backend, como Collections, Stream API, Optional, exceções customizadas, StringBuilder e organização em camadas simples.

## Objetivo

Gerenciar uma lista de contatos em memória, permitindo realizar filtros, buscas, validações, geração de relatório e estatísticas no console.

## Funcionalidades

- Criar e manipular uma lista de contatos
- Filtrar contatos ativos
- Filtrar contatos por cidade
- Filtrar contatos com idade acima de um valor
- Listar nomes ordenados
- Buscar contato por email
- Buscar contato por nome
- Validar email com exceção customizada
- Gerar relatório formatado com StringBuilder
- Contar contatos ativos
- Calcular média de idade
- Agrupar contatos por cidade
- Listar emails de contatos ativos sem repetição

## Tecnologias e conceitos utilizados

- Java
- Programação Orientada a Objetos
- Collections (`List`, `Map`)
- Stream API
- Optional
- OptionalDouble
- Exceptions customizadas
- StringBuilder

## Estrutura do projeto

```text
contact-processor-java/
  src/main/java/
    org/example/Main.java
    model/Contato.java
    exception/ContatoNaoEncontradoException.java
    exception/EmailInvalidoException.java
    service/ContatoService.java
    service/RelatorioService.java
```

## Como executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/contact-processor-java.git
```

2. Abra o projeto na sua IDE de preferência.

3. Execute a classe:
```text
Main.java
```

## Exemplo de saída

```text
--- Buscar por email ---
Encontrado: maria@gmail.com
Resultado com orElse: null
Exceção capturada: Email não encontrado

--- Validar email ---
maria@gmail.com → válido!
Exceção capturada: Email inválido: anaemail.com

--- Estatísticas ---
Quantidade de ativos: 5
Média de idade: 23.83
```

## Aprendizados praticados

Este projeto foi importante para consolidar conhecimentos em:

- modelagem de classes
- uso de construtor, getters, setters e `toString()`
- manipulação de listas com `List`
- filtros e estatísticas com Stream API
- uso de `Optional` para evitar retorno `null`
- criação e uso de exceções customizadas
- geração de textos formatados com `StringBuilder`

## Melhorias futuras

- adicionar menu interativo no console
- salvar contatos em arquivo ou banco de dados
- transformar o projeto em uma API REST com Spring Boot
- adicionar testes automatizados

## Autora

Projeto desenvolvido por Maria como parte dos estudos de Java para backend.
