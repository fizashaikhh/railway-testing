package testproject;
/**
 * Created By Golla Sai Venkatesh
 * testcase - 9 & 38
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class myTicketsTest {

    public static void testMyTickets2(WebDriver webDriver) {
        webDriver.get("http://localhost:63342/Railway-Front-End/index.html?_ijt=svta12kejlkcrcbk8vtm5gphuh");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//input[@id='email']")).sendKeys("gsaivenkatesh@hello.com");
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("HiHello@123");
        webDriver.findElement(By.xpath("//button[@id='submitBtn']")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath("//a[contains(text(),\"Go to My Tickets\")][1]")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            WebElement alert = webDriver.findElement(By.xpath("//p[@id=\"alert\"]"));
            System.out.println("Testcase 2 Passed");
        }
        catch (Exception e){
            System.out.println("Testcase 2 Failed");
        }
        webDriver.quit();
    }
    public static void testMyTickets(WebDriver webDriver) {
        webDriver.get("http://localhost:63342/Railway-Front-End/index.html?_ijt=svta12kejlkcrcbk8vtm5gphuh");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//input[@id='email']")).sendKeys("gollasaivenkatesh@gmail.com");
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("SaiSuji@11");
        webDriver.findElement(By.xpath("//button[@id='submitBtn']")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath("//a[contains(text(),\"Go to My Tickets\")][1]")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int rows = webDriver.findElements(By.xpath("//th[@scope=\"row\"]")).size();
        if(rows == 2){
            System.out.println("Testcase 1 Passed");
        }
        else{
            System.out.println("Testcase 1 Failed");
        }
    }
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        testMyTickets(webDriver);
        testMyTickets2(webDriver);
        webDriver.quit();

    }
}
