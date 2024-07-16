# Projeto de Listagem de Livros

Este é um projeto simples de listagem de livros via console, desenvolvido em Java, utilizando a API da GutenDex para buscar informações de livros e a biblioteca Jackson para conversão dos dados.

## Funcionalidades

- **Buscar livros por título**: Permite buscar livros pelo título e adicionar à base de dados.
- **Listar livros cadastrados**: Lista todos os livros que foram cadastrados no sistema.
- **Listar autores cadastrados**: Lista todos os autores cadastrados no sistema.
- **Listar autores vivos em um determinado ano**: Permite listar autores que estavam vivos em um ano específico.
- **Listar livros em determinado idioma**: Permite listar livros cadastrados em um idioma específico.

## Estrutura do Projeto

- `startLiteralura()`: Método principal que exibe o menu e recebe as opções do usuário.
- `newBook()`: Busca um livro pelo título e o adiciona à base de dados.
- `listBooks()`: Lista todos os livros cadastrados.
- `listAuthors()`: Lista todos os autores cadastrados.
- `listAuthorsLivingByYear()`: Lista autores vivos em um ano específico.
- `listBooksByLanguage()`: Lista livros por idioma.
- `saveData(String data)`: Salva os dados de livros e autores na base de dados.

## Requisitos

- Java 11 ou superior
- Biblioteca Jackson
- Conexão com a API da GutenDex

## Como Executar

1. Clone o repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd <DIRETORIO_DO_PROJETO>
   ```

3. Compile o projeto:
   ```bash
   javac -cp .:lib/jackson-core-2.12.3.jar:lib/jackson-databind-2.12.3.jar:lib/jackson-annotations-2.12.3.jar Main.java
   ```

4. Execute o projeto:
   ```bash
   java -cp .:lib/jackson-core-2.12.3.jar:lib/jackson-databind-2.12.3.jar:lib/jackson-annotations-2.12.3.jar Main
   ```

## Exemplo de Uso

Após iniciar o programa, você verá o seguinte menu:

```
-------------------------------------------
       *** Digite uma das opções ***
-------------------------------------------
1 - Buscar livros por título
2 - Listar livros cadastrados
3 - Listar autores cadastrados
4 - Listar autores vivos em um determinado ano
5 - Listar livros em determinado idioma

0 - Sair
-------------------------------------------
```
