-- INSERTS INICIAIS
INSERT INTO app_financas.categoria_lancamento (id, nome, id_categoria_parent, descricao)
VALUES (1, 'compras', NULL, NULL),
       (2, 'contas fixas', NULL, NULL);
INSERT INTO app_financas.categoria_lancamento (id, nome, id_categoria_parent, descricao)
VALUES (3, 'aluguel', 2, NULL),
       (4, 'condominio', 2, NULL),
       (5, 'viagens', NULL, NULL);
INSERT INTO app_financas.categoria_lancamento (id, nome, id_categoria_parent, descricao)
VALUES (6, 'passagens aereas', 5, NULL),
       (7, 'hospedagens', 5, NULL),
       (8, 'serviços', NULL, NULL),
       (9, 'mercado', NULL, NULL),
       (10, 'rendimentos', NULL, 'Rendimento de investimentos');
INSERT INTO app_financas.categoria_lancamento (id, nome, id_categoria_parent, descricao)
VALUES (11, 'investimentos', NULL, 'Transferencia para conta de investimentos'),
       (12, 'receitas', NULL, NULL);
INSERT INTO app_financas.categoria_lancamento (id, nome, id_categoria_parent, descricao)
VALUES (13, 'salário', 12, NULL),
       (14, 'bonus', 12, NULL);

-- INSERT instituicao
INSERT INTO app_financas.instituicao (nome, descricao, tipo)
VALUES ('Caixa', 'Banco Caixa Economica Federal', 1),
       ('Nubank', 'Banco Nubank', 1),
       ('Inter', 'Banco Inter', 1),
       ('XP', 'Banco XP', 1),
       ('Rico', 'Banco Rico', 1),
       ('Banco do Brasil', 'Banco do Brasil', 1);


-- INSERT TIPO CONTA
INSERT INTO app_financas.tipo_conta (nome)
VALUES ('Conta Corrente'),
       ('Cartão de Crédito'),
       ('Carteira'),
       ('Conta Benefício'),
       ('Judicial'),
       ('FGTS'),
       ('Investimento');