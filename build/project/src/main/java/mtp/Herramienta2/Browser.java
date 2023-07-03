package mtp.Herramienta2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Browser {
	WebDriver webDriver;
	AndroidDriver driver;
	
	public WebDriver seleccionarBrowser(String browser) throws MalformedURLException {
		
		 switch (browser)
	        {
	            case "Chrome":
	            	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\"+"src"+"\\"+"main"+"\\"+"java"+"\\"+"drivers"+"\\"+"chromedriver.exe");
	            	webDriver=new ChromeDriver();
	            	webDriver.manage().window().maximize();
	                 break;
	            case "IE":
	               	System.getProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\"+"src"+"\\"+"main"+"\\"+"java"+"\\"+"drivers"+"\\"+"IEDriverServer.exe");
	        		webDriver=new InternetExplorerDriver();
	        		webDriver.manage().window().maximize();
	                break;
	            case "Firefox":
	            	System.setProperty("webdriver.geckodriver.driver", System.getProperty("user.dir")+"\\"+"src"+"\\"+"main"+"\\"+"java"+"\\"+"drivers"+"\\"+"geckodriver.exe");
	         	    webDriver=new FirefoxDriver();
	         	    webDriver.manage().window().maximize();
	                break;
	       
	            default:
	            	
	                //Trace.WriteLine(String.Format("Browser '{0}' not recognized.  Spawning default Firefox browser.", browser));
	                webDriver = new FirefoxDriver();
	                break;
	        }
		 
		 return webDriver;
		
	}
	
	public AndroidDriver seleccionar_Mobile(String app, String deviceName) throws MalformedURLException {
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		 AppiumServiceBuilder builder;
		
		System.out.println("Iniciando sesión de Appium"); 
		  builder = new AppiumServiceBuilder();
		  builder.usingPort(4730);
		  builder.withIPAddress("127.0.0.1");
		  service = AppiumDriverLocalService.buildService(builder);
		  service.start();
		  if (service.isRunning()) {
		   System.out.println("Sesión iniciada");
		  }
		
			DesiredCapabilities capabilities = new DesiredCapabilities();
	
	    	  capabilities.setCapability("deviceName", deviceName);
	    	  capabilities.setCapability("platformName", "Android");
	    	  capabilities.setCapability(MobileCapabilityType.APP,app);
	    	  capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
	    	  capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
	    	  //capabilities.setCapability("automationName", "UiAutomator2");
	    	  //capabilities.setCapability("newCommandTimeout", "100");
	    	  
	    	  driver = new AndroidDriver(new URL("http://127.0.0.1:4730/wd/hub"), capabilities);
	    	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    

	    	  
	   return driver;
		
	}
	
}
