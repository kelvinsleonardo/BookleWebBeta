-- Script de criação da base de dados e criação da tabela usuário
-- Data de criação: 18-06-2015
-- SGBD: Mysql
-- @Author: Kelvin Santiago


--
-- Criando banco de dados bookleweb se não existir.
--

CREATE DATABASE IF NOT EXISTS bookleteste;


--
-- Utilizando banco de dados bookleweb
--

USE bookleteste;

--
-- Criando estrutura da tabela `tb_usuario`
--

CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `permissao` varchar(255) DEFAULT NULL,
  `senha` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Criando usuário default do sistema bookle: Usuário: 123456 Senha: 123456
--
INSERT INTO `tb_usuario` (`matricula`, `nome`, `permissao`, `senha`, `email`) VALUES
(123456, 'ADMINISTRADOR BOOKLE', 'ROLE_ADMIN', 'e10adc3949ba59abbe56e057f20f883e', 'bookleweb@kelvinsantiago.com.br');
