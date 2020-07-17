# gerenciamento-usuarios
O projeto foi desenvolvido usando o framework SpringBoot para o back-end e Vue Js para o front-end.

## Pré-requisitos
- Instalações necessárias para rodar a aplicação: Java, PostgreSQL, NodeJs.

## Instruções de uso
- Primeiramente, como não foi possível subir a pasta node_modules para o github (estava dando muitos problemas devido ao seu tamanho), é necessário, após fazer o download do projeto, baixar o arquivo node_modules.zip no link https://drive.google.com/file/d/1phOzUujTTTmq-OslyO0zhBsmpklz3A-Q/view?usp=sharing, extrair e adicionar dentro da pasta gerenciamento-usuario-front.

- Antes de iniciar a aplicação, é necessário  criar um novo database PostgreSQL e atualizar o arquivo application.properties no caminho "apirest-gerenciamento-usuarios\src\main\resources\application.properties" de acordo com as configurações do database que foi criado.

- Com o database criado e o application.properties configurado, é necessária iniciar a api no back end do sistema através do arquivo ApiRestApplication.java no caminho "apirest-gerenciamento-usuarios\src\main\java\com\gerenciamento\apirest\ApiRestApplication.java" e posteriormente iniciar a aplicação do front end através do comando "$ npm run serve" pelo terminal estando dentro do diretório gerenciamento-usuarios-front. Feito isso, Abra o link localhost retornado pelo comando e a aplicação deverá estar iniciada.
