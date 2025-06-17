-- V2: migrations para adicionar a coluna specialAbility na tabela de cadastros

ALTER TABLE tb_ninja_registration
ADD COLUMN specialAbility VARCHAR(255);