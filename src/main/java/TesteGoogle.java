import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.junit.*;

public class TesteGoogle {
	@Before
	public void setUp( ) {
		
	}
	@After
	public void tearDown() {
		
	}
	@Test
	public void teste() {
//		System.setProperty( "webdriver.chrome.driver", "/home/v/prog/drivers/chromedriver");
//		ChromeOptions options = new ChromeOptions();
//		options.setBinary("/opt/google/chrome/chrome");
//		WebDriver driver = new ChromeDriver(options);
		
		System.setProperty( "webdriver.gecko.driver", "/home/v/prog/drivers/geckodriver");
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("/opt/firefox/firefox");
		WebDriver driver = new FirefoxDriver(options);
		
		driver.manage().window().maximize();
//		driver.manage().window().setSize(new Dimension(1200, 765));
//		driver.manage().window().setPosition(new Point(200, 200));
		
		driver.get("http://www.google.com");
//		driver.get("file:///home/v/prog/eclipse-workspace/CursoSelenium/campo-treinamento/componentes.html");
	
		Assert.assertEquals("Google", driver.getTitle());
		
//		driver.close();
		driver.quit();
	}
}
