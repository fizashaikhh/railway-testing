import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateUser {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5501/pages/createUser.html");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("bob");
        driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("bob@gmail.com");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("25th Cross XYZ Street");
        driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("12/12/1998");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("23");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@1234");
        driver.findElement(By.xpath("//input[@id='aadhaar']")).sendKeys("2345 0987 3456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try{
            if(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isEnabled())
            {
                System.out.println("valid Credentials");
            }
            else
            {
                System.out.println("invalid credentials");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        driver.quit();
    }
}
