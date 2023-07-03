package operation;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
//import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class UIOperationMobile {

	 AndroidDriver driver;
	
    public UIOperationMobile(AndroidDriver driver){
        this.driver = driver;
    }
    public void perform(Properties p,String operation,String objectName,String objectType,String value) throws Exception{
        System.out.println("");
        switch (operation.toUpperCase()) {
        case "CLICK":
            
        	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.findElement(this.getObject(p,objectName,objectType)).click();
        	
            break;
        case "SETTEXT":
            //Set text on control
            driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
            break;
            
        case "DROPDOWN":
            //Set text on control
            new Select(driver.findElement(this.getObject(p,objectName,objectType))).selectByVisibleText(value);
            break;
            
        case "WAIT":
        	long tiempo = Long.parseLong(value);
        	long resultado=tiempo*1000;
        	System.out.println("tiempo"+resultado);
            Thread.sleep(resultado);
             break;
             
         case "PHOTO":
         	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            	FileUtils.copyFile(scrFile, new File("c:\\evidencias\\"+value+".png"));
         	break;
         	
         case "SWIPEMOVIL":
           	swipeH(driver,0.90,0.10,3000);
          	break;
            
         case "PRESSBACKMOBILE":
        	 driver.pressKeyCode(AndroidKeyCode.BACK);
         	break;
     
        case "GOTOURL":
            driver.get(p.getProperty(value));
            
            break;
            
        case "ALERT":
        	//wait.until(ExpectedConditions.alertIsPresent());
        	//Alert alert = driver.switchTo().alert();
        	//alert.accept();
        	System.out.println("prueba");
        	Thread.sleep(10000);
        	//driver.quit();
        	//driver.resetApp();
        	//driver.;
        	//driver.switchTo();
        	
        	//driver.switchTo().parentFrame();

            break;
            
        case "COMPARETEXT":
           // driver.findElement(this.getObject(p,objectName,objectType)).getText();
        	//driver.switchTo().activeElement();
        	WebElement result= (WebElement)  driver.findElement(this.getObject(p,objectName,objectType));
        	
        	System.out.println(result.getText());
        	String cadena=result.getText();
                 	
        	if (cadena.equals(value))
        	{
              	  System.out.println("Correcto");
        	}else {
        		
        		throw new Exception("Error de cadena");
        	}
            
            break;
            
        default:
            break;
        }
    }
    
    public static void swipeH(AppiumDriver<MobileElement> driver ,double startPercentage,double finalPercentage,int duration) {
		 Dimension size=driver.manage().window().getSize();
		 int width=(int) (size.width/2);
		 int startPoint=(int) (size.getHeight() * startPercentage);
		 int endPoint=(int) (size.getHeight() * finalPercentage);
		 new TouchAction(driver).press(width,startPoint).waitAction(Duration.ofMillis(duration)).moveTo(width,endPoint).release().perform();
		 
	 }
    
    /**
     * Find element BY using object type and value
     * @param p
     * @param objectName
     * @param objectType
     * @return
     * @throws Exception
     */
    private By getObject(Properties p,String objectName,String objectType) throws Exception{
        //Find by xpath
        if(objectType.equalsIgnoreCase("XPATH")){
            
            return By.xpath(p.getProperty(objectName));
        }
        //find by class
        else if(objectType.equalsIgnoreCase("CLASSNAME")){
            
            return By.className(p.getProperty(objectName));
            
        }
        //find by name
        else if(objectType.equalsIgnoreCase("NAME")){
            
            return By.name(p.getProperty(objectName));
            
        }
        //Find by css
        else if(objectType.equalsIgnoreCase("CSS")){
            
            return By.cssSelector(p.getProperty(objectName));
            
        }
        //find by link
        else if(objectType.equalsIgnoreCase("LINK")){
            
            return By.linkText(p.getProperty(objectName));
            
        }
        
       else if(objectType.equalsIgnoreCase("ID")){
            System.out.println("id");
            return By.id(p.getProperty(objectName));
            
        }
        //find by partial link
        else if(objectType.equalsIgnoreCase("PARTIALLINK")){
            
            return By.partialLinkText(p.getProperty(objectName));
            
        }else
        {
            throw new Exception("Wrong object type");
        }
    }
}



