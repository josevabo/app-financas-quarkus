INSERT INTO app_financas.usuario (id, nome, nome_completo, email, senha)
VALUES (1, 'john', 'john doe', 'johndoe@gmail.com', '$2a$04$DrFyDU.9gBkJeXSG5CgQFeav/cJg8mc5BRz7JInHrStPFpMlqCi.O');
INSERT INTO app_financas.conta (codigo, apelido, id_instituicao, id_tipo_conta, id_usuario, afeta_balanco)
VALUES ('9999.001.99999999-9', 'Caixa Corrente', 1, 1, 1, 1),
       (NULL, 'Caixa Cartão de Crédito', 1, 2, 1, 1),
       (NULL, 'Nubank Cartão de Credito', 2, 2, 1, 1);


