Essa é uma aplicação Single Page Application (SPA), essa aplicação Front-End irá consumir informações do Back-end, sendo está outra vantagem do React.

O arquivo .jar do cdc-react é o back-end, que contem o projeto em Java já pronto e você poderá executá-lo na sua máquina. Ele realiza uma conexão com uma base mysql que você precisará ter instalada e configurada no seu computador.

O comando para executar o jar e: java -Dspring.datasource.username=<USERNAME_MYSQL> -Dspring.datasource.password=<PASSWORD_MYSQL> -Dspring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect -jar cdcreact-1.0.0-SNAPSHOT.jar

