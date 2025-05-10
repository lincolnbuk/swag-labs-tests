# Swag Labs Test Automation

![poster](.github/cover.png)

## 🤘 Sobre | About

Projeto para o meu TCC, da Universidade Católica de Pernambuco sobre automação de testes, testando o site Swag Labs. Utiliza Maven, Java e JUnit 5 para automação de testes end-to-end.

Project for my undergraduate thesis at the Catholic University of Pernambuco about test automation, testing the Swag Labs website. Uses Maven, Java, and JUnit 5 for end-to-end test automation.

## 💻 Tecnologias | Technologies

- Selenium WebDriver 4.20.0
- JDK 21
- JUnit 5
- Maven

## 📁 Estrutura do Projeto | Project Structure

```text
chromedriver.exe / geckodriver.exe / msedgedriver.exe  # Drivers dos navegadores
pom.xml                                                # Configuração Maven
src/
  main/java/br/com/tcc/swag_labs/Hello.java            # Código principal (exemplo)
  test/java/br/com/tcc/swag_labs/StatusTest.java       # Testes automatizados
```

- Os arquivos de driver (chromedriver.exe, geckodriver.exe, msedgedriver.exe) são necessários para execução dos testes em diferentes navegadores.
- The driver files (chromedriver.exe, geckodriver.exe, msedgedriver.exe) are required to run tests on different browsers.

## ⚙️ Pré-requisitos | Prerequisites

- Java 21 instalado | Java 21 installed
- Maven instalado | Maven installed
- Navegador Chrome, Firefox ou Edge | Chrome, Firefox or Edge browser

## 🤖 Como executar | How to execute

1. Clone o repositório:

   ```bash
   git clone [<url-do-repositorio>](<url-do-repositorio>)
   ```

2. Certifique-se de que o driver do navegador desejado está na raiz do projeto.
3. Execute os testes com:

   ```bash
   mvn test
   ```

---

1. Clone the repository:

   ```bash
   git clone [<repository-url>](<repository-url>)
   ```

2. Make sure the desired browser driver is in the project root.
3. Run the tests with:

   ```bash
   mvn test
   ```

---

## 🥒 Integração com Cucumber | Cucumber Integration

Este projeto suporta automação de testes com Cucumber (BDD).

This project supports test automation with Cucumber (BDD).

### 📂 Estrutura dos arquivos Cucumber | Cucumber Files Structure

- `src/test/resources/features/` — arquivos `.feature` com cenários em Gherkin
- `src/test/java/br/com/tcc/swag_labs/steps/` — classes Java com os steps
- `src/test/java/br/com/tcc/swag_labs/runner/RunCucumberTest.java` — runner para execução dos testes Cucumber

### 📝 Exemplo de arquivo feature | Feature file example

```gherkin
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
```

### 🚀 Como rodar os testes Cucumber | How to run Cucumber tests

Execute:

```bash
mvn test
```

Os cenários definidos nos arquivos `.feature` serão executados automaticamente.

The scenarios defined in `.feature` files will be executed automatically.

## 🧪 Casos de Teste | Test Cases

Automação do site Swag Labs para estes sete casos de teste:

1. Possuir um carrinho de compras: o sistema deve fornecer aos usuários a capacidade de adicionar itens a um carrinho de compras enquanto navegam pelo site;
2. Seleção de múltiplos produtos: possibilitar ao usuário a inserção de mais de um produto ao carrinho de compras, permitindo compras múltiplas em uma única transação;
3. Confirmação de itens adicionados: antes de finalizar a compra o sistema deve possibilitar a revisão dos itens selecionados no carrinho;
4. Ajuste na quantidade de itens selecionados: deve ser permitido aos usuários ajustar a quantidade de itens adicionados ao carrinho de compras, tanto aumentando quanto diminuindo a quantidade desejada;
5. Boa visualização dos produtos na home page: os produtos devem ser apresentados de forma clara e atrativa, exibindo informações essenciais como nome, descrição, preço e uma foto de preview para facilitar a escolha dos usuários;
6. Visualizar na íntegra todos os produtos na home page: a página inicial do site deve exibir uma lista ou galeria de todos os produtos disponíveis, permitindo aos usuários uma visão geral do catálogo;
7. Permissão de login com credenciais válidas: o sistema deve garantir a segurança das informações dos usuários, incluindo a necessidade de login com credenciais válidas;

Automation of the Swag Labs website for the following seven test cases:

1. Have a shopping cart: The system must provide users with the ability to add items to a shopping cart while browsing the website.
2. Multiple product selection: The system should allow users to add more than one product to the shopping cart, enabling multiple purchases in a single transaction.
3. Confirmation of added items: Before completing the purchase, the system should allow users to review the selected items in the cart.
4. Adjustment of selected item quantities: Users must be able to adjust the quantity of items in the shopping cart, both increasing and decreasing the desired amount.
5. Clear product display on the homepage: Products should be presented clearly and attractively, displaying essential information such as name, description, price, and a preview image to facilitate user choices.
6. Full view of all products on the homepage: The homepage must display a list or gallery of all available products, allowing users to have an overview of the catalog.
7. Allow login with valid credentials: The system must ensure the security of user information, including requiring login with valid credentials.

---

## 🤝 Como contribuir | How to contribute

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nome-feature`)
3. Commit suas alterações (`git commit -m 'feat: minha nova feature'`)
4. Faça um push para a branch (`git push origin feature/nome-feature`)
5. Abra um Pull Request

6. Fork the project
7. Create a branch for your feature (`git checkout -b feature/feature-name`)
8. Commit your changes (`git commit -m 'feat: my new feature'`)
9. Push to the branch (`git push origin feature/feature-name`)
10. Open a Pull Request

## 📫 Contato | Contact

- Email: <sit-bull@hotmail.com>
- LinkedIn: [Seu LinkedIn](https://www.linkedin.com/in/adrianolincoln)

---
