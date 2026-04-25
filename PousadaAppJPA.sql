DROP DATABASE if exists PousadaappJPA;

CREATE DATABASE IF NOT EXISTS PousadaappJPA;
USE PousadaappJPA;

CREATE TABLE Hospede(
id INT NOT NULL AUTO_iNCREMENT,
nome VARCHAR(30) NOT NULL,
cpf VARCHAR(14) NOT NULL,
idade INT NOT NULL,
contato VARCHAR(15) NOT NULL,
numeroDeDias INT NOT NULL,
identificacaoQuarto VARCHAR(10) NOT NULL,
saldo double(9,2) NOT NULL,
primary key(id)
);

CREATE TABLE Usuario(
id INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(30) NOT NULL,
login VARCHAR(30) NOT NULL,
senha TEXT NOT NULL,
tipo VARCHAR (30) NOT NULL,
PRIMARY KEY (ID)
);

CREATE TABLE gastos(
id INT NOT NULL AUTO_INCREMENT,
data varchar(12) NOT NULL,
descricao VARCHAR(30) NOT NULL,
valor DOUBLE (9,2) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE Caixa (
 id INT NOT NULL AUTO_INCREMENT, 
 saldoTotal DOUBLE(9,2) NOT NULL DEFAULT 0, 
 PRIMARY KEY (id)
 );
 
CREATE TABLE SenhaTeste (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255),
    senha_original VARCHAR(255),
    senha_md5 VARCHAR(32)
);


SELECT*FROM USUARIO;
SELECT*FROM HOSPEDE;
SELECT*FROM GASTOS;
SELECT SUM(VALOR) FROM GASTOS;
SELECT*FROM SENHATESTE;

/*
logins e senhas: @filipe  senha: adm123 tipo: Administrador
                 @dulci   senha: dulci109 tipo: Proprietaria
                 @maria   senha: mari123 tipo: Secretaria
*/




