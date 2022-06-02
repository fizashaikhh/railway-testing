package testproject;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class fetchMealsTest {
	public static void main(String a[]) {

		test("http://127.0.0.1:5501/index.html");

	}
	
	public static void test(String url) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		driver.findElement(By.xpath("(//a[@id='checkmeal'])")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Select trainNumber = new Select(driver.findElement(By.name("train")));
		trainNumber.selectByValue("10111");
		driver.findElement(By.xpath("(//a[@id='submitBtn'])")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
