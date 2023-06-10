CREATE TABLE conta (
  id INT PRIMARY KEY AUTO_INCREMENT,
  login VARCHAR(50) NOT NULL UNIQUE,
  senha VARCHAR(50) NOT NULL
);

CREATE TABLE produto (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  quantidade VARCHAR(50) NOT NULL,
  valor DOUBLE NOT NULL,
  conta_id INT NOT NULL,
  FOREIGN KEY (conta_id) REFERENCES conta(id)
);

-- Inserção na tabela "conta"
INSERT INTO conta (login, senha) VALUES ('joao', 'senha123');
INSERT INTO conta (login, senha) VALUES ('maria', 'abc123');
INSERT INTO conta (login, senha) VALUES ('pedro', 'qwerty');

-- Inserção na tabela "produto"
INSERT INTO produto (conta_id, nome, quantidade, valor) VALUES (1, 'Camiseta', '10 unidades', 29.99);
INSERT INTO produto (conta_id, nome, quantidade, valor) VALUES (1, 'Calça Jeans', '5 unidades', 79.99);
INSERT INTO produto (conta_id, nome, quantidade, valor) VALUES (2, 'Tênis', '8 unidades', 99.99);
INSERT INTO produto (conta_id, nome, quantidade, valor) VALUES (2, 'Camisa Social', '3 unidades', 59.99);
INSERT INTO produto (conta_id, nome, quantidade, valor) VALUES (3, 'Sapato', '12 unidades', 149.99);
