import java.util.List;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	public WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty( "webdriver.gecko.driver", "/home/v/prog/drivers/geckodriver");
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("/opt/firefox/firefox");
		options.addArguments("start-maximized");
		driver = new FirefoxDriver(options);
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void testTextField() {
		String inputText = "Victor";
		String elementId = "elementosForm:nome";
		WebElement element = driver.findElement(By.id(elementId));
		element.sendKeys(inputText);
		
		String findText = element.getAttribute("value");
		
		Assert.assertEquals(inputText, findText);
	}
	
	@Test
	public void testTextArea() {
		String inputText = "Teste\ntexto\noutra linha";
		String elementId = "elementosForm:sugestoes";
		WebElement element = driver.findElement(By.id(elementId));
		element.sendKeys(inputText);
		
		String findText = element.getAttribute("value");
		
		Assert.assertEquals(inputText, findText);
	}
	
	@Test
	public void testRadioButton() {
		String elementId = "elementosForm:sexo:0";
		WebElement element = driver.findElement(By.id(elementId));
		element.click();
		
		boolean isSelected = element.isSelected();
		
		Assert.assertTrue(isSelected);
	}

	@Test
	public void testCheckbox() {
		String elementId = "elementosForm:comidaFavorita:0";
		WebElement element = driver.findElement(By.id(elementId));
		element.click();
		
		boolean isSelected = element.isSelected();
		
		Assert.assertTrue(isSelected);
	}

	@Test
	public void testSelect() {
		String elementId = "elementosForm:escolaridade";
		String textOption = "2o grau incompleto";
		WebElement element = driver.findElement(By.id(elementId));
		
		Select selected = new Select(element);
		
//		selected.selectByIndex(2);
//		selected.selectByValue("2grauincomp");
		selected.selectByVisibleText(textOption);
		
		String selectedText = selected.getFirstSelectedOption().getText();
		
		Assert.assertEquals(textOption, selectedText);
	}

	@Test
	public void testSelectVerifyValues() {
		String elementId = "elementosForm:escolaridade";
		String textOption = "2o grau incompleto";
		WebElement element = driver.findElement(By.id(elementId));
		
		Select selected = new Select(element);
		List<WebElement> options = selected.getOptions();
		
		Assert.assertEquals(8, options.size());
	}

	@Test
	public void testSelectVerifyAmount() {
		String elementId = "elementosForm:escolaridade";
		WebElement element = driver.findElement(By.id(elementId));
		
		Select selected = new Select(element);
		List<WebElement> options = selected.getOptions();
		
		boolean optionExist = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				optionExist = true;
				break;
			}
		}
		
		Assert.assertTrue(optionExist);
	}

	@Test
	public void testSelectVerifyMultiplesValues() {
		String elementId = "elementosForm:esportes";
		WebElement element = driver.findElement(By.id(elementId));
		
		Select selected = new Select(element);
		
		selected.selectByVisibleText("Natacao");
		selected.selectByVisibleText("Corrida");
		selected.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = selected.getAllSelectedOptions();
		
		Assert.assertEquals(3, allSelectedOptions.size());
	}

	@Test
	public void testFirstButton() {
		String elementId = "buttonSimple";
		WebElement element = driver.findElement(By.id(elementId));
		
		element.click();
		
		String elementValue = element.getAttribute("value");
		
		Assert.assertEquals("Obrigado!", elementValue);
	}

	@Test
//	@Ignore
	public void testLink() {
		String elementText = "Voltar";
		String idResultado = "resultado";
		
		WebElement element = driver.findElement(By.linkText(elementText));
		
		element.click();
		
		WebElement elementResultado = driver.findElement(By.id(idResultado));
		String elementResultadoText = elementResultado.getText();
		
		Assert.assertEquals("Voltou!", elementResultadoText);
	}

	@Test
	public void testText() {
//		WebElement element = driver.findElement(By.tagName("body"));
//		boolean containText = element.getText().contains("Campo de Treinamento");
//		Assert.assertTrue(containText);
		
		String text = "Campo de Treinamento";
		WebElement element = driver.findElement(By.tagName("h3"));
		String elementText = element.getText();
		
		Assert.assertEquals(text, elementText);
	}
}
