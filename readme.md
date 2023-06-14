# API de Cadastro de Contas e Produtos

Este é um projeto que implementa uma API RESTful para cadastro de contas de usuário e produtos. A API oferece diversas rotas para realizar operações relacionadas a contas e produtos.

## Arquitetura

A API foi desenvolvida seguindo a arquitetura geralmente conhecida como "Controller-Service-Repository" (ou simplesmente "CSR").

- **Controllers**: Os controllers são responsáveis por receber as requisições HTTP, interpretá-las e acionar as ações apropriadas. Eles recebem os dados enviados pelos clientes e os encaminham para os serviços correspondentes. Os controllers também são responsáveis por retornar as respostas adequadas para as requisições.

- **Services**: Os services são responsáveis por implementar a lógica de negócio da aplicação. Eles encapsulam as operações relacionadas às regras de negócio e interagem com os repositories para acessar e manipular os dados. Os services são acionados pelos controllers para executar as operações solicitadas.

- **Repositories**: Os repositories são responsáveis pelo acesso aos dados da aplicação. Eles fornecem métodos para realizar operações de leitura e gravação nos dados armazenados, abstraindo a complexidade das operações de acesso ao banco de dados. Os repositories são acionados pelos services para acessar os dados necessários.

- **DTOs**: Os DTOs (Data Transfer Objects) são objetos utilizados para transferir dados entre as diferentes camadas da aplicação. Eles representam uma estrutura simplificada dos dados a serem transmitidos e ajudam a evitar o vazamento de informações sensíveis. Os DTOs são utilizados para receber e enviar dados nas requisições e respostas da API.

- **Errors**: A API utiliza uma estrutura de tratamento de erros para lidar com exceções e retornar respostas apropriadas em caso de falhas. Os erros são representados por objetos específicos que contêm informações sobre a falha ocorrida. Esses objetos são transformados em respostas JSON para fornecer informações detalhadas sobre o erro ao cliente.

## Rotas

A seguir estão listadas as rotas disponíveis na API, juntamente com seus métodos HTTP correspondentes e uma breve descrição:

| Rota                      | Método | Descrição                                                  |
| ------------------------- | ------ | --------------------------------------------------------- |
| `/cadastrarLogin`         | POST   | Cadastrar uma nova conta de usuário                        |
| `/login`                  | POST   | Realizar login em uma conta existente                      |
| `/conta`                  | GET    | Obter todas as contas cadastradas                          |
| `/produto`                | POST   | Cadastrar um novo produto associado a uma conta            |
| `/produto`                | GET    | Obter todos os produtos cadastrados                        |
| `/produto/conta/{contaId}`| GET    | Obter todos os produtos associados a uma conta específica   |
| `/produto/conta/login/{contaLogin}`| GET | Obter todos os produtos associados a uma conta pelo login |
| `/produto/{id}`           | GET    | Obter um produto pelo seu ID                               |
| `/produto/{id}`           | DELETE | Excluir um produto pelo seu ID                             |

## Descrição dos objetos de resposta

Aqui estão as descrições dos objetos JSON retornados pelas rotas da API:

### :white_check_mark: ResponseCadastrarLogin

| Propriedade  | Tipo   | Descrição                                           |
| ------------ | ------ | -------------------------------------------------- |
| `status`     | string | "OK" em caso de sucesso, "NOK" em caso de erro     |
| `mensagem`   | string | Mensagem de erro, caso ocorra algum erro           |

### :rocket: RequestLogin

| Propriedade  | Tipo   | Descrição                                           |
| ------------ | ------ | -------------------------------------------------- |
| `login`      | string | Login da conta de usuário                           |
| `senha`      | string | Senha da conta de usuário                           |

### :key: ResponseLogin

| Propriedade  | Tipo   | Descrição                                           |
| ------------ | ------ | -------------------------------------------------- |
| `status`     | string | "OK" em caso de sucesso, "NOK" em caso de erro     |
| `usuario`    | string | Nome do usuário logado, caso o login seja bem-sucedido |
| `mensagem`   | string | Mensagem de erro, caso ocorra algum erro           |

### :card_file_box: ResponseObterContas

| Propriedade  | Tipo       | Descrição                                           |
| ------------ | ---------- | -------------------------------------------------- |
| `status`     | string     | "OK" em caso de sucesso, "NOK" em caso de erro     |
| `contas`     | array      | Lista de contas obtidas                             |
| `mensagem`   | string     | Mensagem de erro, caso ocorra algum erro           |

### :heavy_plus_sign: ResponseCadastrarProduto

| Propriedade  | Tipo   | Descrição                                           |
| ------------ | ------ | -------------------------------------------------- |
| `status`     | string | "OK" em caso de sucesso, "NOK" em caso de erro     |
| `mensagem`   | string | Mensagem de erro, caso ocorra algum erro           |

### :mag: ResponseObterProdutos

| Propriedade  | Tipo       | Descrição                                           |
| ------------ | ---------- | -------------------------------------------------- |
| `status`     | string     | "OK" em caso de sucesso, "NOK" em caso de erro     |
| `produtos`   | array      | Lista de produtos obtidos                           |
| `mensagem`   | string     | Mensagem de erro, caso ocorra algum erro           |

### :pencil2: ResponseObterProduto

| Propriedade  | Tipo       | Descrição                                           |
| ------------ | ---------- | -------------------------------------------------- |
| `status`     | string     | "OK" em caso de sucesso, "NOK" em caso de erro     |
| `produto`    | object     | Produto obtido                                      |
| `mensagem`   | string     | Mensagem de erro, caso ocorra algum erro           |

### :x: ResponseExcluirProduto

| Propriedade  | Tipo   | Descrição                                           |
| ------------ | ------ | -------------------------------------------------- |
| `status`     | string | "OK" em caso de sucesso, "NOK" em caso de erro     |
| `mensagem`   | string | Mensagem de erro, caso ocorra algum erro           |
