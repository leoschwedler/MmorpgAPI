-- Migration para adicionar a coluna de damage na tabela de itens

ALTER TABLE tb_item
ADD COLUMN damage INT;