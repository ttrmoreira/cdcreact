Passos para rodar o exemplo
-----------------------

1. Importe o projeto dentro Eclipse IDE.

2. Adicione as seguintes bibliotecas para a pasta lib.(Elas foram removidas para reduzir o tamanho do projeto)
antlr-2.7.6.jar
asm-attrs.jar
asm.jar
c3p0-0.9.1.jar
cglib-2.1.3.jar
commons-collections-2.1.1.jar
dom4j-1.6.1.jar
hibernate-shards.jar
hibernate3.jar
mysql-connector-java-5.1.16-bin.jar
j2ee.jar
jta.jar
log4j-1.2.11.jar

4. Criar a tabela CONTATO utilizando o seguinte comando.
CREATE TABLE CONTATO(CONTATOID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
INQUILINOID INT,
NOME VARCHAR(120),
TELEFONE VARCHAR(30),
ENDERECO VARCHAR(100))

5. Rode a classe ContatoApp.java para executar o exemplo. 

