import com.google.common.collect.Table;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class testGraphs {


    public static void main(String[] args) {

        WebDriver driver=WebDriverManager.chromedriver().create();
        driver.get("https://www.justdial.com/");
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.navigate().back();
        driver.getCurrentUrl();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com/");

        try{
            driver.manage().window().fullscreen();
            driver.wait(2000);
        }
        catch (InterruptedException interupted){
            System.out.println("The flow halted:"+interupted.getMessage());
        }



    }

}
