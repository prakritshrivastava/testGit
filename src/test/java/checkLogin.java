import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

public class checkLogin {

    //Create secret key with valid length (google it, should be > 6)
    private static final String SECRET_KEY="naveenautomation";
    private static Properties prop;


    public static String encrypt(String valueToEncrypt){

        try{
            //In a room of 3 persons , one person reads specification before operation, the specification gets the bytes and data is in AES algorithm
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(),"AES");
            //The cipher man is called, he gets the instance i.e. book which has the toad of AES inside ECB chapter, he then installs padding on the person PK
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            //Then cipher man starts the encrypt machine and passes the secret specification
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            //then cipher starts encoding by going into the base of the process , encrypts it and confirms if its final, if yes then finalizes it.
            return Base64.getEncoder().encodeToString(cipher.doFinal(valueToEncrypt.getBytes()));
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String decrypt(String valueToDecrypt){
        try{
            //In a room of 3 persons , one person reads specification before operation, the specification gets the bytes and data is in AES algorithm
            SecretKeySpec secretSpec = new SecretKeySpec(SECRET_KEY.getBytes(),"AES");
            //The cipher man is called, he gets the instance i.e. book which has the toad of AES inside ECB chapter, he then installs padding on the person PK
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            //Then cipher man starts the decrypt machine and passes the secret specification
            cipher.init(Cipher.DECRYPT_MODE,secretSpec);
            //then cipher is called immediately and asked to finalize quickly, then he completes the process by going into the base of the process , decodes it.
            return new String(cipher.doFinal(Base64.getDecoder().decode(valueToDecrypt)));
        }
        catch (Exception exp){
            System.out.println(exp.getMessage());
            return null;
        }
    }

    public static Properties readProp(){

        try{
            //Initialize property reader
            prop=new Properties();
            FileInputStream configStream = new FileInputStream("./src/test/resources/config.properties");
            prop.load(configStream);
            return prop;
        }
        catch (IOException ioexp){
            System.out.println(ioexp.getMessage());
            return null;
        }
    }

//    public static void testEncryption(){
//        String encryptedPassword=encrypt("myPassword!123");
//        System.out.println(encryptedPassword);
//    }

    public static void main(String[] args) {

        readProp();
        String pass_encrypted_value=prop.getProperty("password");
        String decrypted_value=decrypt(pass_encrypted_value);
        System.out.println("Decrypted value:"+decrypted_value);

        try{


            WebDriver driver =WebDriverManager.chromedriver().create();
            driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();

            //Get all elements in list
            List<WebElement> options = driver.findElements(By.xpath("//li[contains(@class,'dropdown open')]/ul/li"));

            //Search for exact element and select the same
            for(WebElement option: options){
                if(option.getText().contains("Login")){
                    option.click();
                }
            }

            Thread.sleep(2000);
            driver.findElement(By.cssSelector("input#input-email")).sendKeys("naveensecure@nal.com");
            driver.findElement(By.cssSelector("input#input-password")).sendKeys("myPassword!123");
            driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
            Thread.sleep(2000);

        }catch(InterruptedException ioexp){
            System.out.println("Automation labs:"+ioexp.getMessage());
        }


    }

}
