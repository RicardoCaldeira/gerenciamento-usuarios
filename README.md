# gerenciamento-usuarios
O projeto foi desenvolvido usando o framework SpringBoot para o back-end e Vue Js para o front-end.

## Pré-requisitos
- Instalações necessárias para rodar a aplicação: Java, PostgreSQL, NodeJs.

## Instruções de uso
- Primeiramente, como não foi possível subir a pasta node_modules para o github, pois estava dando muitos problemas devido ao seu tamanho. Após fazer download do projeto, baixar o arquivo node_modules.zip no link https://drive.google.com/file/d/1phOzUujTTTmq-OslyO0zhBsmpklz3A-Q/view?usp=sharing, extrair e adicionar dentro da pasta gerenciamento-usuario-front.

- Antes de iniciar a aplicação, é necessário  criar um novo database no PostgreSQL e atualizar o arquivo application.properties no caminho "apirest-gerenciamento-usuarios\src\main\resources\application.propertires" de acordo com as configurações do database que foi criado.

- Com o database criado, é necessária iniciar a api no back end do sistema através do arquivo ApiRestApplication.java no caminho "C:\Users\ricar\eclipse-workspace\gerenciamento-usuario\apirest-gerenciamento-usuarios\src\main\java\com\gerenciamento\apirest\ApiRestApplication.java" e posteriormente iniciar a aplicação do front end através do comando "$ npm run serve" pelo terminal dentro do diretório gerenciamento-usuarios-front. Abra o link localhost retornado pelo comando e a aplicação estará iniciada.
