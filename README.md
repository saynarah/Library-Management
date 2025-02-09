# Arquitetura de Microsserviços - Especialiazação em Engenharia de Software 

### Palavras-chave

* IntelliJ
* Java
* Spring Boot
* Swagger
* Health
* H2
* Arquitetura multicamadas
* Exceptions
* Logger


### Funcionalidades

Uma API para gerenciamento de livros de uma biblioteca com os seguintes end points:
1. GET ("/books/allBooks") -Listar todos os livros
2. POST ("/books/newBook") - Cadastrar um novo livro
3. GET ("/books/{id}") - Listar informações de um livro através do id do livro cadastrado*
4. DELETE ("/books/{id}") - Excluir um livro do sistema através do id do livro cadastrado*
5. UPDATE ("/books/{id}") - Atualizar um livro do sistema através do id do livro cadastrado*

* Para esses três tipos de requisições, existe tratamento de exceções.

### Principais passos:

1. Criação da entidade 'Book' com seus atributos de identificação;
2. Criação das classes DTO para request e response da requisição ('CreateRequestDTO' e 'ResponseRequestDTO);
3. Criação da interface BookRepository extendendo a interface JpaRepository<Book, UUID>;
4. Criação das classes Services com os respectivos métodos de cada end-point (createBook,getAllBooks,getBookbyId,deleteBook,updateBook);
5. Tratamento de exceção para os seguintes métodos da service: getBookbyId, deleteBook and updateBook;
6. Sinalização de log info messages na entrada e na saída de cada um dos métodos da service.

