package operation;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
//import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;

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
            
        case "WAIT":
            Thread.sleep(5000);
             break;
             
         case "PHOTO":
         	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            	FileUtils.copyFile(scrFile, new File("c:\\evidencias\\"+value+".png"));
         	break;
            
        case "GOTOURL":
            //Get url of application
            driver.get(p.getProperty(value));
            break;
        case "GETTEXT":
            //Get text of an element
            driver.findElement(this.getObject(p,objectName,objectType)).getText();
            break;
        default:
            break;
        }
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



