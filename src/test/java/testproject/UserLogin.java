package testproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:5501/");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("bob@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@1234");
        driver.findElement(By.xpath("//button[@id='submitBtn']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            driver.quit();
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}
