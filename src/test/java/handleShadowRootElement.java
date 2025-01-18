import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class handleShadowRootElement {


    public static void main(String[] args) {

        try{
            //Initialize the driver and open the website
            WebDriver driver=WebDriverManager.chromedriver().create();
            driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

            //Switch to frame
            Thread.sleep(180000);
            driver.switchTo().frame("pact");
            Thread.sleep(2000);

            //Encapsulate the target element inside a webelement by treating it as a javascript and casting the driver for the same
            JavascriptExecutor textElementJavaScript = (JavascriptExecutor) driver;
            WebElement teaTextBox = (WebElement)textElementJavaScript.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");

            //Execute the script on the webElement to pass it a value
            String scriptToEnterText="arguments[0].setAttribute('value','chaha')";
            textElementJavaScript.executeScript(scriptToEnterText,teaTextBox);
        }
        catch (InterruptedException intexp){
            System.out.println(intexp.getMessage());
        }



    }
}
