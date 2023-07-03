package prueba;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SetUp {
	
	WebDriver driver;
	String path="C:\\Driver_browsers\\chromedriver_win32\\";
	
	@Test
	public WebDriver iniciar() {
		
		System.setProperty("webdriver.chrome.driver", path+"chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/mercuryregister.php");
		
		return driver;
	}
	
}
