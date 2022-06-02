import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddTrain {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://127.0.0.1:5501/admin/pages/loginAdmin.html");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            driver.quit();
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("devesh");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass@1234");
        driver.findElement(By.xpath("//button[@id='submitBtn']")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            driver.quit();
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//button[contains(text(), \"OK!\")]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            driver.quit();
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//a[contains(text(), \"Create new trains\")]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            driver.quit();
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//input[@id='trainNumber']")).sendKeys("762894");
        driver.findElement(By.xpath("//input[@id='totalSeats']")).sendKeys("445");
        driver.findElement(By.xpath("//input[@id='departure']")).sendKeys("Lucknow");
        driver.findElement(By.xpath("//input[@id='arrival']")).sendKeys("Chandigarh");
        driver.findElement(By.xpath("//input[@id='departureDate']")).sendKeys("2022-07-15");
        driver.findElement(By.xpath("//input[@id='arrivalDate']")).sendKeys("2022-07-15");
        driver.findElement(By.xpath("//a[contains(text(), 'Add New Train')]")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            driver.quit();
            throw new RuntimeException(e);
        }

        String message = driver.findElement(By.xpath("//div[@role = 'alert']")).getText();
        if(message.equals("Train Created")) {
            System.out.println("Success");
        } else {
            System.out.println(message);
        }

        driver.quit();

    }
}
