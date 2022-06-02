package testproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminLoginTest {

	public static void main(String a[]) {
		
		test("http://127.0.0.1:5501/index.html", "Admin", "Admin@123");
	test("http://127.0.0.1:5501/index.html", "Admina", "Admin@1234");
		test("http://127.0.0.1:5501/index.html", "", "Admin@1234");
		test("http://127.0.0.1:5501/index.html", "Admina", "1234");
		test("http://127.0.0.1:5501/index.html", "Admina", "");
		
		test("http://127.0.0.1:5501/index.html", "DeactivatedAdmin", "Admin@12345");

	}

	public static void test(String url, String username, String password) {

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

		driver.findElement(By.xpath("(//div[@id='mybutton'])")).click();

		driver.findElement(By.xpath("//input[@type='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
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
			if (driver.getCurrentUrl().equals("http://127.0.0.1:5501/admin/pages/adminPanel.html"))
				System.out.println("In AdminPanel");
			else
				System.out.println("Not In AdminPanel");

		}

		catch (org.openqa.selenium.NoSuchElementException e) {

			WebElement message = driver.findElement(By.xpath("//div[@id=\"message\"]"));

			System.out.println("Log in Failed as " + message.getText());

		}

		driver.quit();
	}

}
