# language: pt

Funcionalidade: Login no Swag Labs
  Como um usuário
  Quero fazer login no sistema
  Para acessar os produtos

  Cenário: Login com credenciais válidas
    Dado que estou na página de login
    Quando informo usuário "standard_user" e senha "secret_sauce"
    E clico no botão de login
    Então devo ver a página de produtos
