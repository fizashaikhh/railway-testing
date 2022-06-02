package org.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AdminActivateDeactivateTest {

    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup(); //opens chrome browser
        WebDriver webDriver = new ChromeDriver(); //ChromeDriver class reference is hold by interface WebDriver

        webDriver.get("http://127.0.0.1:5501/"); //standard screen size
        webDriver.manage().window().maximize(); //full screen
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement AdminTag = webDriver.findElement(By.xpath("(//*[@id=\"mybutton\"]/button)"));
        Actions actions = new Actions(webDriver); //for performing any actions
        actions.moveToElement(AdminTag).perform();

        webDriver.findElement(By.xpath("//*[@id=\"mybutton\"]/button")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Admin");
        webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Admin@1234");
        webDriver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        webDriver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div/div/a")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebElement DeactivateTag = webDriver.findElement(By.xpath("//*[@id=\"adminDetailsTable\"]/tbody/tr[1]/td[5]/button"));
        Actions DactAction = new Actions(webDriver); //for performing any actions
        DactAction.moveToElement(DeactivateTag).perform();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath("//*[@id=\"adminDetailsTable\"]/tbody/tr[1]/td[5]/button")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
        try {
            Thread.sleep(2500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebElement ActivateTag = webDriver.findElement(By.xpath("//*[@id=\"adminDetailsTable\"]/tbody/tr[1]/td[5]/button"));
        Actions AactAction = new Actions(webDriver); //for performing any actions
        AactAction.moveToElement(ActivateTag).perform();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath("//*[@id=\"adminDetailsTable\"]/tbody/tr[1]/td[5]/button")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
        try {
            Thread.sleep(2500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        webDriver.quit();
    }

}
