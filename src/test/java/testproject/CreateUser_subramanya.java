package testproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class CreateUser_subramanya {
    public static int delay = 3000;
    public static int success = 0;
    public static int failure = 0;

    public static void main(String args[]) {
        Random rand = new Random();
        String url = "http://127.0.0.1:5501/pages/createUser.html";
        test(url, "user1", "user" + rand.nextInt(500000) + "@gmail.com", "address", "12/12/2000", "32", "Asdf@1234", "3333 3333 3333");
        test(url, "user1", "user1@gmail.com", "address", "12/12/2000", "32", "Asdf@1234", "3333 3333 3333");
        test(url, "user1", "user" + rand.nextInt(500000), "address", "12/12/2000", "32", "Asdf@1234", "3333 3333 3333");
        test(url, "user1", "user" + rand.nextInt(500000) + "@gmail.com", "address", "12/12/2000", "32", "Asdf@1234", "3333 3333 3333");
        test(url, "user1", "user" + rand.nextInt(500000) + "@gmail.com", "address", "12/000", "32", "Asdf@1234", "3333 3333 3333");
        test(url, "user1", "user" + rand.nextInt(500000) + "@gmail.com", "address", "12/12/2000", "-20", "Asdf@1234", "3333 3333 3333");
        test(url, "user1", "user" + rand.nextInt(500000) + "@gmail.com", "address", "12/12/2000", "-20", "", "3333 3333 3333");
        test(url, "user1", "user" + rand.nextInt(500000) + "@gmail.com", "address", "12/12/2000", "32", "Asdf@1234", "23231323123132");
        test(url, "user1", "user" + rand.nextInt(500000) + "@gmail.com", "address", "12/12/2000", "32", "Asdf@1234", "1113 3333 3333");

        System.out.println("Test results: Success=" + success + ";Failure=" + failure);
    }

    public static void test(String url, String username, String emailId, String address, String dob, String age, String password, String aadhaar) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        try {
            Thread.sleep(delay);
        } catch (InterruptedException ignored) {
        }

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys(emailId);
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(dob);
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys(age);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='aadhaar']")).sendKeys(aadhaar);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try {
            Thread.sleep(delay);
        } catch (InterruptedException ignored) {
        }

        try {
            driver.findElement(By.xpath("//div[contains(text(), 'User register successfully')]"));
            System.out.println("User created successfully");
            success += 1;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            WebElement message = driver.findElement(By.xpath("//div[@id=\"message\"]"));
            System.out.println("Failed to add user: " + message.getText());
            failure++;
        }

        try {
            Thread.sleep(delay);
        } catch (InterruptedException ignored) {
        }
        driver.quit();
    }
}
