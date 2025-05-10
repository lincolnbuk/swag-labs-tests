package br.com.tcc.swag_labs.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {
    private WebDriver driver;
    private static final String BROWSER = "firefox";

    @Dado("que estou na página de login")
    public void que_estou_na_pagina_de_login() {
        setDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Quando("informo usuário {string} e senha {string}")
    public void informo_usuario_e_senha(String usuario, String senha) {
        driver.findElement(By.id("user-name")).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(senha);
    }

    @Quando("clico no botão de login")
    public void clico_no_botao_de_login() {
        driver.findElement(By.id("login-button")).click();
    }

    @Entao("devo ver a página de produtos")
    public void devo_ver_a_pagina_de_produtos() {
        WebElement productsTitle = driver.findElement(By.cssSelector(".title"));
        assertEquals("Products", productsTitle.getText());
        driver.quit();
    }

    private void setDriver() {
        if (BROWSER.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        } else if (BROWSER.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver(options);
        } else if (BROWSER.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Navegador não suportado: " + BROWSER);
        }
    }
}
