package br.com.tcc.swag_labs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class StatusTest {

	private WebDriver driver;
	private static final String BROWSER = "firefox"; // Altere para "firefox" ou "edge" conforme necessário

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

	@AfterEach
	void tearDown() {
		if (driver != null) {
			driver.quit(); // Fecha o navegador e encerra o WebDriver
		}
	}

	@Test
	@DisplayName("Deve exibir o status do site")
	void siteStatusTest() {
		setDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://www.saucedemo.com/");

		// Ajuste o seletor para um elemento válido
		WebElement title = driver.findElement(By.cssSelector(".login_logo")); // Exemplo de ajuste

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> title.isDisplayed());

		assertEquals("Swag Labs", title.getText(), "Verificando o Status do site");
		System.out.println("Status do site: " + title.getText());
	}

	@Test
	@DisplayName("Deve permitir adicionar itens ao carrinho de compras")
	void addItemToCartTest() {
		setDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		WebElement addToCartButton = driver.findElement(By.cssSelector(".inventory_item button"));
		addToCartButton.click();

		WebElement cartBadge = driver.findElement(By.cssSelector(".shopping_cart_badge"));
		assertTrue(cartBadge.isDisplayed(), "O item foi adicionado ao carrinho");
	}

	@Test
	@DisplayName("Deve permitir a seleção de múltiplos produtos")
	void addMultipleItemsToCartTest() {
		setDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*", "--disable-dev-shm-usage", "--no-sandbox");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		System.out.println("Log: Página inicial carregada com sucesso.");

		// Verifica se os botões de adicionar ao carrinho estão disponíveis
		List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".inventory_item button"));
		assertTrue(addToCartButtons.size() >= 5, "Pelo menos cinco itens devem estar disponíveis para adicionar");

		System.out.println("Log: Botões de adicionar ao carrinho encontrados.");

		// Adiciona cinco itens ao carrinho
		for (int i = 0; i < 5; i++) {
			addToCartButtons.get(i).click();
		}

		System.out.println("Log: Cinco itens adicionados ao carrinho.");

		// Acessa o carrinho
		driver.findElement(By.cssSelector(".shopping_cart_link")).click();

		// Espera explícita para garantir que os itens estão no carrinho
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Aumentado para 20 segundos
		wait.until(d -> d.findElements(By.cssSelector(".cart_item")).size() == 5);

		System.out.println("Log: Itens confirmados no carrinho.");

		// Verifica se os itens estão no carrinho
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_item"));
		assertEquals(5, cartItems.size(), "Cinco itens foram adicionados ao carrinho");
	}

	@Test
	@DisplayName("Deve permitir revisar os itens no carrinho antes de finalizar a compra")
	void reviewCartItemsTest() {
		setDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		// Adiciona um item ao carrinho
		WebElement addToCartButton = driver.findElement(By.cssSelector(".inventory_item button"));
		addToCartButton.click();

		// Acessa o carrinho
		driver.findElement(By.cssSelector(".shopping_cart_link")).click();

		// Espera explícita para garantir que o item está visível no carrinho
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Aumentado para 10 segundos
		wait.until(d -> d.findElements(By.cssSelector(".cart_item")).size() > 0);

		// Verifica se o item está no carrinho
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_item"));
		assertTrue(cartItems.size() > 0, "O item está visível no carrinho");
	}

	@Test
	@DisplayName("Deve permitir ajustar a quantidade de itens no carrinho")
	void adjustCartItemQuantityTest() {
		setDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		// Verifica se os botões de adicionar ao carrinho estão disponíveis
		List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".inventory_item button"));
		assertTrue(addToCartButtons.size() >= 2, "Pelo menos dois itens devem estar disponíveis para adicionar");

		// Adiciona itens ao carrinho
		addToCartButtons.get(0).click();
		addToCartButtons.get(1).click();

		// Acessa o carrinho
		driver.findElement(By.cssSelector(".shopping_cart_link")).click();

		// Espera explícita para garantir que os itens estão no carrinho
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(d -> d.findElements(By.cssSelector(".cart_item")).size() == 2);

		// Verifica se os itens estão no carrinho
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_item"));
		assertEquals(2, cartItems.size(), "Dois itens foram adicionados ao carrinho");

		// Remove um item do carrinho
		WebElement removeButton = cartItems.get(0).findElement(By.cssSelector(".cart_button"));
		removeButton.click();

		// Verifica se o carrinho foi atualizado
		cartItems = driver.findElements(By.cssSelector(".cart_item"));
		assertEquals(1, cartItems.size(), "Um item foi removido do carrinho");
	}

	@Test
	@DisplayName("Deve exibir os produtos de forma clara na home page")
	void displayProductsOnHomePageTest() {
		setDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
		assertTrue(products.size() > 0, "Os produtos estão sendo exibidos na home page");

		for (WebElement product : products) {
			assertTrue(product.findElement(By.cssSelector(".inventory_item_name")).isDisplayed(),
					"Nome do produto visível");
			assertTrue(product.findElement(By.cssSelector(".inventory_item_price")).isDisplayed(),
					"Preço do produto visível");
		}
	}

	@Test
	@DisplayName("Deve permitir login com credenciais válidas")
	void validLoginTest() {
		setDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		WebElement productsTitle = driver.findElement(By.cssSelector(".title"));
		assertEquals("Products", productsTitle.getText(), "Login realizado com sucesso");
	}
}
