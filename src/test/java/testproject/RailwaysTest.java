package testproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RailwaysTest {

    public static void testValidCreateUserDetails(WebDriver webDriver) {
        webDriver.get("http://127.0.0.1:5501/pages/createUser.html");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//input[@id='username']")).sendKeys("Ranjana Ram");
        webDriver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("Rajan112@gmail.com");
        webDriver.findElement(By.xpath("//input[@id='address']")).sendKeys("India");
        webDriver.findElement(By.xpath("//input[@id='dob']")).sendKeys("12-04-2000");
        webDriver.findElement(By.xpath("//input[@id='age']")).sendKeys("56");
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("Byte@2020");
        webDriver.findElement(By.xpath("//input[@id='aadhaar']")).sendKeys("6778 7865 5432");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            WebElement element = webDriver.findElement(By.xpath("//div[@id='message']¯"));
            if(element.getText().equals("User register successfully!")) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testInvalidCreateUserDetails(WebDriver webDriver) {
        webDriver.get("http://127.0.0.1:5501/pages/createUser.html");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//input[@id='username']")).sendKeys("Akash");
        webDriver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("akash@gmail.com");
        webDriver.findElement(By.xpath("//input[@id='address']")).sendKeys("India");
        webDriver.findElement(By.xpath("//input[@id='dob']")).sendKeys("12-04-2000");
        webDriver.findElement(By.xpath("//input[@id='age']")).sendKeys("56");
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("Byte@2020");
        webDriver.findElement(By.xpath("//input[@id='aadhaar']")).sendKeys("68787865 5432");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            WebElement element = webDriver.findElement(By.xpath("//div[@id='message']"));
            if(element.getText().equals("User register successfully!")) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testValidBookTicketDetails(WebDriver webDriver) {
        webDriver.get("http://127.0.0.1:5501/index.html");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//input[@id='email']")).sendKeys("naman@yahoo.com");
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("Capman@22");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath("(//a[contains(text(), 'Go to Ticket Booking')])[1]")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Select source = new Select(webDriver.findElement(By.id("trainSource")));
        source.selectByValue("Mumbai");
        Select destination = new Select(webDriver.findElement(By.id("trainDestination")));
        destination.selectByValue("Bengaluru");
        Select number = new Select(webDriver.findElement(By.id("trainNumber")));
        number.selectByValue("11111");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(webDriver.findElement(By.xpath("//h2[@id='swal2-title']")).isDisplayed()) {
                System.out.println("Booked");
                try {
                    Thread.sleep(2500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(webDriver.findElement(By.xpath("//h2[@id='swal2-title']")).isDisplayed()) {
                    webDriver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
                    System.out.println("Success");
                }

            } else if(webDriver.findElement(By.xpath("//h2[@id='swal2-html-container']")).isDisplayed()) {
                webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
                System.out.println("Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testInvalidBookTicketDetails(WebDriver webDriver) {
        webDriver.get("http://127.0.0.1:5501/index.html");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//input[@id='email']")).sendKeys("naman@yahoo.com");
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("Capman@22");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath("(//a[contains(text(), 'Go to Ticket Booking')])[1]")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Select source = new Select(webDriver.findElement(By.id("trainSource")));
        source.selectByValue("Chandigarh");
        Select destination = new Select(webDriver.findElement(By.id("trainDestination")));
        destination.selectByValue("Bengaluru");
        Select number = new Select(webDriver.findElement(By.id("trainNumber")));
        number.selectByValue("11111");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(webDriver.findElement(By.xpath("//div[@id='swal2-html-container']")).isDisplayed()) {
                webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
                System.out.println("Ticket Booking Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
//        testValidCreateUserDetails(webDriver);
//        testInvalidCreateUserDetails(webDriver);
//        testValidBookTicketDetails(webDriver);
        testInvalidBookTicketDetails(webDriver);
        webDriver.quit();

    }
}