package operation;
import java.io.File;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

public class UIOperation {
    WebDriver driver;
    String winHandleBefore;
    public UIOperation(WebDriver driver){
        this.driver = driver;
    }
    public void perform(Properties p,String operation,String objectName,String objectType,String value) throws Exception{
        System.out.println("");
        switch (operation.toUpperCase()) {
        case "CLICK":
            //Perform click
            driver.findElement(this.getObject(p,objectName,objectType)).click();
            break;
        case "SETTEXT":
            //Set text on control
            driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
            break;
            
        case "GOTOURL":
            //Get url of application
            driver.get(p.getProperty(value));
            winHandleBefore = driver.getWindowHandle();
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
            
        case "SWIPEWEB":
             ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,1000)");
          	break;
            
        case "PHOTO":
        	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           	FileUtils.copyFile(scrFile, new File("c:\\evidencias\\"+value+".png"));
        	break;
        	
        case "SWITCH":
        	for(String winHandle : driver.getWindowHandles()){
        	    driver.switchTo().window(winHandle);
        	}
        	break;
            
        case "COMPARETEXT":
           // driver.findElement(this.getObject(p,objectName,objectType)).getText();
            WebElement result= (WebElement)  driver.findElement(this.getObject(p,objectName,objectType));
            Assert.assertEquals(result.getText(), value);
            break;
            
        default:
        	throw new Exception("Wrong object type");
        }
    }
    
    public static void swipeH(WebDriver driver ,double startPercentage,double finalPercentage,int duration) {
		 Dimension size=driver.manage().window().getSize();
		 int width=(int) (size.width/2);
		 int startPoint=(int) (size.getHeight() * startPercentage);
		 int endPoint=(int) (size.getHeight() * finalPercentage);
		 new TouchAction((PerformsTouchActions) driver).press(width,startPoint).waitAction(Duration.ofMillis(duration)).moveTo(width,endPoint).release().perform();
		 
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

