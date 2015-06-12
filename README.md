# BookleWeb
Sistema Bookle Web - Gerenciador Acadêmico 

Sistema destinado a fornecer métodos de pesquisa de livros sugeridos na ementa da disciplina.

# Arquitetura - Desenvolvido em Java EE (Web)
1. JPA - Framework para a persistencia dos dados.
2. Framework Spring MVC - Framework para utilização do Design Pattern MVC (Model And View), e injeção de dependencias.
  1. Model - Criação das classes modelo
  2. View - Utilizado JSP com outros frameworks.
  3. Control - Servlets do pŕoprio Spring
3. Framework Spring Security - Framework para gerenciamento de autenticação, e criação de sessão.
4. JasperReport - Geração de relatórios.
6. Bootstrap - Criação do Front-end reponsível.
7. SGBD MySQL - Sistema gerenciador de banco de dados
8. Ajax - AJAX carregar e renderizar uma página, utilizando recursos de scripts rodando pelo lado cliente.
9. Jquery Validator - Validação de campos.
10. JSP - Páginas geradas dinamicamente.

# Módulos do sistema
1. Pesquisa Livros Sugeridos
2. CRUD Curso - Gerenciador Curso
3. CRUD Disciplina - Gerenciador Disciplina
4. CRUD Livro - Gerenciador Livro
5. Vincular Livro na Disciplina
6. CRUD Usuário - Gerenciador Usuário
7. Relatório de Cursos.
8. Relatório de Disciplinas.
9. Relatório de Livros.
10. Relatório de Usuários.


# Design Responsive
Design Responsivo é uma técnica de estruturação HTML e CSS, em que o site se adapta ao browser do usuário sem precisar definir diversas folhas de estilos para cada resolução, então juntamente com o bootstrap, customizamos todo o sistema para adaptar aos diferentes tamanhos de tela.


# Instalação
1. Faça o clone deste projeto com git clone https://github.com/kelvinsleonardo/BookleWeb.git
2. Crie um banco de dados MYSQL com o nome de bookleweb
3. Edite o arquivo src/main/resources/META-INF/persistence.xml e altere o nome do usuário e senha, conforme seus dados do banco de dados, o banco de dados está configurado com o usuário e senha: "root".
4. Edite o arquivo src/main/webapp/WEB-INF/applicationContext.xml e altere o nome do usuário e senha, conforme seus dados do banco de dados , o sistema está configurado com o usuário e senha: "root".
5. Execute o sistema e acesse: http://localhost:9090/BookleWeb
6. Feito isso é necessário criar um usuário administrador para ter acesso a todas funcionalidades do sistema, isso deve ser feito no próprio banco de dados, então vá no seu SGBD e insere a seguinte linha na tabela "tb_usuario":
  1. Matrícula: Pode ser qualquer número, exemplo: 1312015
  2. Nome: Qualquer nome completo (Deve ser completo), exemplo: Kélvin Santiago
  3. Permissão: Existe 3 níveis de permissão no sistema "ROLE_ALUNO", "ROLE_PROFESSOR", "ROLE_ADMIN" então coloque "ROLE_ADMIN" para permissão FULL.
  4. Senha: Acesse http://www.md5.cz/ e gere uma senha em MD5.
  5. Email: Insira seu email, exemplo bookleweb@gmail.com.
7. Feito essas configurações é só acessar o sistema em http://localhost:9090/BookleWeb e logar com o novo usuário que foi cadastrado anteriormente.

# Testando aplicação BookleWeb
Acesse: http://localhost:9090/BookleWeb

# Javadoc
Para visualizar o javadoc do sistema acesse: http://rawgit.com/kelvinsleonardo/BookleWeb/master/src/main/javadoc/site/apidocs/index.html

# Demo do sistema
Acesse: http://bookleweb.kelvinsantiago.com.br

# Screenshot do sistema
![Alt text](http://www.kelvinsantiago.com.br/blog/wp-content/uploads/2015/06/LOGIN.png "Login")

![Alt text](http://www.kelvinsantiago.com.br/blog/wp-content/uploads/2015/06/BookleWeb_Home.png "Tela Home")

![Alt text](http://www.kelvinsantiago.com.br/blog/wp-content/uploads/2015/06/BookleWeb_GerenciadorDisciplina.png "Gerenciador Disciplina")

![Alt text](http://www.kelvinsantiago.com.br/blog/wp-content/uploads/2015/06/BookleWeb_Pesquisa.png "Pesquisa Livro")

