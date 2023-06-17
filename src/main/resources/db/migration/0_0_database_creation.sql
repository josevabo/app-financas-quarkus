CREATE TABLE categoria_lancamento
(
    id                  BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome                VARCHAR(30)                       NOT NULL UNIQUE,
    id_categoria_parent BIGINT,
    descricao           VARCHAR(250)
);
CREATE TABLE conta
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    codigo         VARCHAR(30),
    apelido        VARCHAR(70)                       NOT NULL,
    id_instituicao BIGINT,
    id_tipo_conta  BIGINT                            NOT NULL,
    id_usuario     BIGINT                            NOT NULL,
    afeta_balanco  BOOL                              NOT NULL DEFAULT 1
);
CREATE TABLE usuario
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome          VARCHAR(30)                       NOT NULL UNIQUE,
    nome_completo VARCHAR(100)                      NOT NULL,
    email         VARCHAR(100)                      NOT NULL UNIQUE,
    senha         VARCHAR(100)                      NOT NULL

);
CREATE TABLE instituicao
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome      VARCHAR(30)                       NOT NULL UNIQUE,
    descricao VARCHAR(2000),
    tipo      INT                               NOT NULL
);
CREATE TABLE lancamento
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    id_conta           BIGINT                            NOT NULL,
    valor              DECIMAL(10, 2)                    NOT NULL,
    data               DATE                              NOT NULL,
    id_categoria       BIGINT                            NOT NULL,
    descricao          VARCHAR(70)                       NOT NULL,
    ts_criacao         TIMESTAMP                         NOT NULL DEFAULT NOW(),
    id_destino         BIGINT,
    id_lncmto_anterior BIGINT                            NULL COMMENT 'identifica lançamento anterior associado. Exemplo: em caso de estorno, ajuda a encontrar lançamento original. Em caso de rendimentos, ajuda a identificar aplicaçao original'
);
CREATE TABLE tipo_conta
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(30)                       NOT NULL
);
CREATE TABLE destino_lancamento
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(30)                       NOT NULL UNIQUE
);
ALTER TABLE categoria_lancamento
    ADD CONSTRAINT fk_categoria_parent_id FOREIGN KEY (id_categoria_parent) REFERENCES categoria_lancamento (id);
ALTER TABLE conta
    ADD CONSTRAINT fk_conta_instituicao FOREIGN KEY (id_instituicao) REFERENCES instituicao (id);
ALTER TABLE conta
    ADD CONSTRAINT fk_conta_tipo_conta FOREIGN KEY (id_tipo_conta) REFERENCES tipo_conta (id);
ALTER TABLE conta
    ADD CONSTRAINT fk_conta_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id);
ALTER TABLE lancamento
    ADD CONSTRAINT fk_lancamento_conta FOREIGN KEY (id_conta) REFERENCES conta (id);
ALTER TABLE lancamento
    ADD CONSTRAINT fk_lancamento_categoria FOREIGN KEY (id_categoria) REFERENCES categoria_lancamento (id);
ALTER TABLE lancamento
    ADD CONSTRAINT fk_lancamento_destino FOREIGN KEY (id_destino) REFERENCES destino_lancamento (id);
ALTER TABLE lancamento
    ADD CONSTRAINT fk_lancamento_anterior FOREIGN KEY (id_lncmto_anterior) REFERENCES lancamento (id);
