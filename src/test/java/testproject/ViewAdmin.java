package testproject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewAdmin {

	//Tests View , Activate and delete Admin

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

		driver.findElement(By.xpath("(//div[@id='myadminbutton'])")).click();

		driver.findElement(By.xpath("//input[@type='username']")).sendKeys("SuperAdmin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperAdmin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			driver.findElement(By.xpath("//div[contains(text(), 'Successfully logged in')]"));
			System.out.println("Login Success");
			driver.findElement(By.xpath("//button[contains(text(), 'OK!')]")).click();
			if (driver.getCurrentUrl().equals("http://127.0.0.1:5501/admin/pages/superadminPanel.html"))
				System.out.println("In SupperAdmin Panel");
			else {
				System.out.println("Not In SuperAdmin Panel");
				return;
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver.findElement(By.xpath("(//a[@href=\"./viewAdmins.html\"])[2]")).click();

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> table = driver.findElements(By.xpath("//table[@class='table table-striped dataTable no-footer']/tbody/tr"));
			System.out.println(table.size() + " Admin/Admins Retrieved Successfully");
			
	
			WebElement activate = driver.findElement(By.xpath("(//button[contains(text(),'Deactivate')])[1]"));
			
			//String adminid= driver.findElement(By.xpath("//table[@class='table table-striped dataTable no-footer']/tbody/tr[2]/td[1]")).getText();

			activate.click();
			

			
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		try {	
			
		driver.findElement(By.xpath("//button[contains(text(),'Yes, deactivate it!')]")).click();
		

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[contains(text(),'Admin has been deactivated successfully')]"));
		
		driver.findElement(By.xpath("//button[contains(text(),'OK!')]")).click();

		System.out.println("Admin deactivated Successfully");
		}
		catch (org.openqa.selenium.NoSuchElementException e) {

			System.out.println("Failed to deactivate Admin ");

		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		WebElement deactivate = driver.findElement(By.xpath("(//button[contains(text(),'Activate')])[1]"));
		deactivate.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		//button[contains(text(),'OK!')]
		try {	
			
		driver.findElement(By.xpath("//button[contains(text(),'Yes, activate it!')]")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//div[contains(text(),'Admin has been activated successfully')]"));
		System.out.println("Admin activated Successfully");
		}
		catch (Exception e) {

			System.out.println("Failed to activate Admin ");

		}
		
		

		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}

		catch (Exception e) {

			System.out.println("Failed to retrieve AdminDetails ");

		}

		driver.quit();

	}

}
