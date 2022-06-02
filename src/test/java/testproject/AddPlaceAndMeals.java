package testproject;


import org.openqa.selenium.By;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddPlaceAndMeals {
    public static void main(String[] args) {

	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();

	    driver.get("http://127.0.0.1:5501/index.html");
	    
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    driver.findElement(By.xpath("//*[@id=\"mybutton\"]/button")).click();
	   
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
//	    TEST 1
	    driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("");
	    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
	    driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();	
	    
	    try {
	    	if(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equals("Username cant be empty")) {
	    		System.out.println("Test 1 passed :valid message shown for empty body");
	    	}else {
	    		System.out.println(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText());
	    		System.out.println("Test 1 falied");
	    	}
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
//	    TEST 2
	    driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("randomGuy");
	    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
	    driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();	
	    
	    try {
	    	if(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equals("Password cant be empty")) {
	    		System.out.println("Test 2 passed :valid message shown for empty password");
	    	}else {
	    		System.out.println(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText());
	    		System.out.println("Test 2 falied");
	    	}
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//	    TEST 3
//	    driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
//	    driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
//	    driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("randGuy");
//	    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("P@sss1234");
//	    driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();	
//	    
//	    try {
//	    	Thread.sleep(1000);
//	    	if(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equals("Admin doesnt exist by that username")) {
//	    		System.out.println("Test 3 passed :valid message shown for invalid credentials");
//	    	}else {
//	    		System.out.println(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText());
//	    		System.out.println("Test 3 falied");
//	    	}
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    
//	    TEST 4
	    driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Test");
	    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("P@ss1234");
	    driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();	
	    
	    try {
	    	Thread.sleep(500);
	    	if(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equals("Incorrect password")) {
	    		System.out.println("Test 4 passed :valid message shown for incorrect password");
	    	}else {
	    		System.out.println(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText());
	    		System.out.println("Test 4 falied");
	    	}
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
//	    TEST 5
	    driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Test");
	    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Test@1234");
	    driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();	
	    
	    
	    try {
	    	Thread.sleep(1000);
	    	if(driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).isDisplayed()) {
	    		System.out.println("Test 5 passed :valid credentials");
	    		driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
	    	}else {
	    		System.out.println("Test 5 falied");
	    	}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
//      TEST 6
	    driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div/div/a")).click();
	    
	     try {
	    	Thread.sleep(500);
	    	if(driver.findElement(By.xpath("//*[@id=\"adminDetailsTable\"]")).isDisplayed()) {
	    		System.out.println("Test 6 passed : table with all admins was displayed");
	    	}else {
	    		System.out.println(driver.findElement(By.xpath("//*[@id=\"adminDetailsTable\"]")).getText());
	    		System.out.println("Test 6 falied");
	    	}
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
//      TEST 7  - DeactivateAdmin
	     
//	     if(driver.findElement(By.xpath("//*[@id=\"adminDetailsTable\"]/tbody/tr[2]/td[4]/span")).getText().equals("Active")) {
//	    	 //deactivate it
//	    	 driver.findElement(By.xpath("//*[@id=\"adminDetailsTable\"]/tbody/tr[2]/td[5]/button")).click();
//	    	 try {
//				Thread.sleep(1000);
//	    	 } catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//	    	 }
//	    	 driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
//	    	 
//	    	 try {
//					Thread.sleep(1000);
//		    	} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//		    	}
//	    	 driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
//	    	 try {
//	 	    	Thread.sleep(1000);
//	 	    	if(driver.findElement(By.xpath("//*[@id=\"adminDetailsTable\"]/tbody/tr[2]/td[4]/span")).getText().equals("Inactive")) {
//	 	    		System.out.println("Test 7 passed : Admin deactivated successfully");
//	 	    	}else {
//	 	    		System.out.println("Test 7 falied");
//	 	    	}
//	 			Thread.sleep(2000);
//	 		} catch (InterruptedException e) {
//	 			// TODO Auto-generated catch block
//	 			e.printStackTrace();
//	 		}
//	     }else {
//	    	 //activate it
//	    	 driver.findElement(By.xpath("//*[@id=\"adminDetailsTable\"]/tbody/tr[2]/td[5]/button")).click();
//	    	 try {
//					Thread.sleep(500);
//		    	 } catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//		    	 }
//		    driver.findElement(By.xpath("//html/body/div[2]/div/div[6]/button[1]")).click();
//		    try {
//						Thread.sleep(500);
//			    	} catch (InterruptedException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//			    	}
//		     driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
//		     try {
//					Thread.sleep(500);
//		    	} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//		    	}
//		     try {
//		 	    	Thread.sleep(500);
//		 	    	if(driver.findElement(By.xpath("//*[@id=\"adminDetailsTable\"]/tbody/tr[2]/td[4]/span")).getText().equals("Active")) {
//		 	    		System.out.println("Test 7 passed : Admin activated successfully");
//		 	    	}else {
//		 	    		System.out.println("Test 7 falied");
//		 	    	}
//		 			Thread.sleep(2000);
//		 		} catch (InterruptedException e) {
//		 			// TODO Auto-generated catch block
//		 			e.printStackTrace();
//		 		}
//	     }
//	     
//	    
	     driver.navigate().back();
	     
//       TEST 8
	     //Actions actions = new Actions(driver);
	     
	     driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div/div/a")).click();
	     driver.findElement(By.xpath("//*[@id=\"trainNumber\"]")).sendKeys("1");
	     //driver.findElement(By.xpath("/html/body/div[1]/form/div[5]/a")).click();
	     //actions.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/form/div[5]/a"))).click().perform();
	     WebElement element = driver.findElement(By.xpath("/html/body/div[1]/form/div[5]/a"));
	     JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click()", element);
	     
	     try {
	 	    	Thread.sleep(500);
	 	    	
	 	    	if(driver.switchTo().alert().getText().equals("Please fill all the details.")) {
	 	    		System.out.println("Test 8 passed : cant submit with empty fields");
	 	    		driver.switchTo().alert().accept();
	 	    	}else {
	 	    		System.out.println(driver.switchTo().alert().getText());
	 	    		System.out.println("Test 8 falied : meals added with empty fields");
	 	    		Thread.sleep(3000);
	 	    		driver.findElement(By.xpath("/html/body/div[5]/div/div[6]/button[1]")).click();
	 	    	}
	 			Thread.sleep(2000);
	 			
	 		} catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}

	     driver.navigate().back();
	    
//		TEST 9
	    driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/div/div/a")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"placeId\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
	    
	    try {
	    	Thread.sleep(1000);
	    	driver.switchTo().alert();
	    	if(driver.switchTo().alert().getText().equals("Failed")) {
	    		System.out.println("Test 9 passed: couldn't submit an empty field");
	    	}else {
	    		//System.out.println(driver.switchTo().alert().getText());
	    		System.out.println("Test 9 failed");
	    	}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    driver.switchTo( ).alert( ).accept();
	    
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
//		TEST 10
	    //driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/div/div/a")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"placeId\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"placeId\"]")).sendKeys(String.valueOf(Math.random()));
	    driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
	    
	    try {
	    	Thread.sleep(1000);
	    	driver.switchTo().alert();
	    	if(driver.switchTo().alert().getText().equals("Failed")) {
	    		System.out.println("Test 10 passed: couldn't submit an number field");
	    	}else {
	    		//System.out.println(driver.switchTo().alert().getText());
	    		System.out.println("Test 10 failed");
	    	}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    driver.switchTo( ).alert( ).accept();
	    
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	    driver.navigate().back();
	    
	    
	      
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
	    driver.close();
	}
}
