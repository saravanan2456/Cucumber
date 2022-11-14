package com.flibkart.stepinto;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;


public class MobileSteps {
	static  WebDriver driver;
	
	@Given("user login to flipkart")
	public void user_login_to_flipkart() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		try {
//			driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(user);
//			driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(pass);
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			} catch (Exception e) {
				System.out.println("Login not required");
			}
	   }
	
	String input;
    @When("user search mobile")
	public void user_search_mobile() throws Exception {
    	input = "Samsung mobiles";
    	driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
    	WebElement mobileClick = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
        String mName = mobileClick.getText();
       
        mobileClick.click(); 
    	   }
	
   
    @When("user choose the mobile")
	public void user_choose_the_mobile() {
    	String parent= driver.getWindowHandle();
    	Set<String> child = driver.getWindowHandles();
    	for(String x:child) {
    		if(!x.equals(child)) {
    			driver.switchTo().window(x);
    		}
    	}
    	
	
	}

	@When("user doing payment by using UPI")
	public void user_doing_payment_by_using_UPI() throws InterruptedException {
		System.out.println("dropdown and screenshot");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement buy=driver.findElement(By.xpath("//button[@type='button']"));
		js.executeScript("arguments[0].scrollIntoView(true)", buy);
		String buynow=buy.getText();
		 Thread.sleep(3000);
	    buy.click();
//	    WebElement input= driver.findElement(By.xpath("//button[@type='button']"));
//	    input.findElement(By.xpath("//input[@class='_2IX_2- _17N0em']")).click();
	    Assert.assertEquals("BUY NOW", buynow);
	}

	@Then("user receives confirmation message")
	public void user_receives_confirmation_message() {
		driver.close();
		}
	
	
	
	
	
	@When("user search mobile by using oneD list")
	public void user_search_mobile_by_using_oneD_list(DataTable dataTable) {
	    List<String>  datas= dataTable.asList();
	    input = datas.get(2);
    	driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
    	WebElement mobileClick = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
         mobileClick.click(); 
    	   }
	
	@When("user search mobile by using oneD map")
	public void user_search_mobile_by_using_oneD_map(DataTable dataTable) {
	    Map<String, String>datas= dataTable.asMap(String.class, String.class);
	 input = datas.get("phone2");
 	driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
 	WebElement mobileClick = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
      mobileClick.click(); 
 	   }
	
	@When("user search mobile {string}")
	public void user_search_mobile(String string) {
		input=string;
		driver.findElement(By.name("q")).sendKeys(input,Keys.ENTER);
	 	WebElement mobileClick = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
	      mobileClick.click(); 
		
		
	}
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	



	
	
	


