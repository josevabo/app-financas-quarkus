-- FASE 2 - TABELAS DE VIEW
CREATE TABLE view_total_por_categoria_mensal
(
    valor        DECIMAL(10, 2) NOT NULL,
    mes_ano      DATE           NOT NULL,
    id_categoria INT            NOT NULL,
    id_usuario   INT            NOT NULL
);
ALTER TABLE view_total_por_categoria_mensal
    ADD CONSTRAINT fk_view_total_por_categoria_mensal_categoria FOREIGN KEY (id_categoria)  REFERENCES categoria_lancamento (id);
ALTER TABLE view_total_por_categoria_mensal
    ADD CONSTRAINT fk_view_total_por_categoria_mensal_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id);