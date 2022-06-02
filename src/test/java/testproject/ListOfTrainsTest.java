package testproject;
/**
 * Created By Chandan Kumar
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ListOfTrainsTest {

    private static final String HOST = "http://127.0.0.1:5501";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        webDriver.get(HOST + "/index.html");
        webDriver.manage().window().maximize();

        Thread.sleep(2000);

        webDriver.findElement(By.xpath("//input[@id='email']")).sendKeys("bob@gmail.com");
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@1234");
        webDriver.findElement(By.xpath("//button[@id='submitBtn']")).click();

        Thread.sleep(2000);

        webDriver.get(HOST + "/pages/listTrains.html");

        Thread.sleep(2000);

        WebElement selectElement = webDriver.findElement(By.name("trainsTable_length"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByValue("100");

        Thread.sleep(2000);

        WebElement textElement = webDriver.findElement(By.xpath("//*[@id=\"trainsTable_info\"]"));
        String[] split = textElement.getText().split(" ");
        int total = Integer.parseInt(split[5]);

        int rows = webDriver.findElements(By.xpath("//*[@id=\"trainsTable\"]/tbody/tr")).size();
        WebElement elementNext = webDriver.findElement(By.xpath("//*[@id=\"trainsTable_next\"]"));
        String classes = elementNext.getAttribute("class");

        while (!classes.contains("disabled")) {
            clickButton(webDriver, elementNext);
            Thread.sleep(2000);
            rows = rows + webDriver.findElements(By.xpath("//*[@id=\"trainsTable\"]/tbody/tr")).size();
            elementNext = webDriver.findElement(By.xpath("//*[@id=\"trainsTable_next\"]"));
            classes = elementNext.getAttribute("class");
        }

        if (total == rows) {
            System.out.println("Test successful");
        } else {
            System.out.println("Test Failed: Row count is not synced with text");
        }

        webDriver.quit();
    }

    private static void clickButton(WebDriver webDriver, WebElement elementNext) {
        Actions action = new Actions(webDriver);
        action.moveToElement(elementNext).click().build().perform();
    }
}
