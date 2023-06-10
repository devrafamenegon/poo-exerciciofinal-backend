# API de Cadastro de Contas e Produtos

Este é um projeto que implementa uma API RESTful para cadastro de contas de usuário e produtos. A API oferece diversas rotas para realizar operações relacionadas a contas e produtos.

## Rotas

A seguir estão listadas as rotas disponíveis na API, juntamente com seus métodos HTTP correspondentes e uma breve descrição:

### Contas

#### `POST /cadastrarLogin`

Cadastrar uma nova conta de usuário.

Payload: Conta (JSON)

Resposta de sucesso: ResponseCadastrarLogin (JSON)

Resposta de erro: ResponseCadastrarLogin (JSON)

#### `POST /login`

Realizar login em uma conta existente.

Payload: Conta (JSON)

Resposta de sucesso: ResponseLogin (JSON)

Resposta de erro: ResponseLogin (JSON)

### Produtos

#### `POST /produto`

Cadastrar um novo produto associado a uma conta.

Payload: Produto (JSON)

Resposta de sucesso: ResponseCadastrarProduto (JSON)

Resposta de erro: ResponseCadastrarProduto (JSON)

#### `GET /produto`

Obter todos os produtos cadastrados.

Resposta de sucesso: ResponseObterProdutos (JSON)

Resposta de erro: ResponseObterProdutos (JSON)

#### `GET /produto/conta/{contaId}`

Obter todos os produtos associados a uma conta específica.

Parâmetro de rota: contaId (inteiro)

Resposta de sucesso: ResponseObterProdutos (JSON)

Resposta de erro: ResponseObterProdutos (JSON)

#### `GET /produto/{id}`

Obter um produto pelo seu ID.

Parâmetro de rota: id (inteiro)

Resposta de sucesso: ResponseObterProduto (JSON)

Resposta de erro: ResponseObterProduto (JSON)

#### `DELETE /produto/{id}`

Excluir um produto pelo seu ID.

Parâmetro de rota: id (inteiro)

Resposta de sucesso: ResponseExcluirProduto (JSON)

Resposta de erro: ResponseExcluirProduto (JSON)

## Descrição dos objetos de resposta

Aqui estão as descrições dos objetos JSON retornados pelas rotas da API:

### ResponseCadastrarLogin

- `status` (string): "OK" em caso de sucesso, "NOK" em caso de erro.
- `mensagem` (string): Mensagem de erro, caso ocorra algum erro.

### ResponseLogin

- `status` (string): "OK" em caso de sucesso, "NOK" em caso de erro.
- `usuario` (string): Nome do usuário logado, caso o login seja bem-sucedido.
- `mensagem` (string): Mensagem de erro, caso ocorra algum erro.

### ResponseCadastrarProduto

- `status` (string): "OK" em caso de sucesso, "NOK" em caso de erro.
- `mensagem` (string): Mensagem de erro, caso ocorra algum erro.

### ResponseObterProdutos

- `status` (string): "OK" em caso de sucesso, "NOK" em caso de erro.
- `produtos` (array de Produto): Lista de produtos obtidos.
- `mensagem` (string): Mensagem de erro, caso ocorra algum erro.

### ResponseObterProduto

- `status` (string): "OK" em caso de sucesso, "NOK" em caso de erro.
- `produto` (Produto): Produto obtido.
- `mensagem` (string): Mensagem de erro, caso ocorra algum erro.

### ResponseExcluirProduto

- `status` (string): "OK" em caso de sucesso, "NOK" em caso de erro.
- `mensagem` (string): Mensagem de erro, caso ocorra algum erro.
