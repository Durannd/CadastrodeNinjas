-- V3: Migrations para adicionar coluna de Rank na tabela de cadastros
ALTER TABLE tb_cadastro
ADD COLUMN RANK VARCHAR(255);