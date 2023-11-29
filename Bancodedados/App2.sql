CREATE DATABASE app2;
CREATE TABLE IF NOT EXISTS aluno (id int AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255) NOT NULL, idade int, email VARCHAR(255), endereco VARCHAR(255) CHECK (endereco NOT LIKE '%[^0-9A-Za-z\s\-\,]%'), cep VARCHAR(15) CHECK (CEP NOT LIKE '%[^0-9]%'), telefone VARCHAR(15) CHECK (telefone NOT LIKE '%[^0-9\-]%'), usuario VARCHAR(255), senha VARCHAR(255) , curso VARCHAR(50) CHECK (curso IN ('ADS', 'Engenharia', 'Medicina')), observacoes VARCHAR(255),  ativo BOOLEAN CHECK (ativo IN (TRUE, FALSE)));
