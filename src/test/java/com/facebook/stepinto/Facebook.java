package com.facebook.stepinto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	static  WebDriver driver;
	@Given("launch facebook url")
	public void launch_facebook_url() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().deleteAllCookies();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
	  }

	@Given("enter user details")
	public void enter_user_details() throws AWTException, InterruptedException {
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("sarwan");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("s");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("saravananrtr@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("saravananrtr@gmail.com");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("apache");
        
        WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
               Select s= new Select(day);
               s.selectByValue("15");
               WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
               Select s1= new Select(month);
               s1.selectByVisibleText("May");
               WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
               Select s2= new Select(year);
               s2.selectByValue("1990");
               driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
               }

	@When("signup")
	public void signup() {
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
	    }
	
	
	@And("signup confirmation")
	public void signup_confirmation() {
		}
	

	@When("enter facebook home")
	public void enter_facebook_home() {
		}
	

	@Then("signout")
	public void signout() throws InterruptedException {
//		Thread.sleep(7000);
//	    driver.close();
	}
	
	
	@Given("enter user details by using oneD map")
	public void enter_user_details_by_using_oneD_map(DataTable dataTable) throws InterruptedException {
		Map<String, String>datas= dataTable.asMap(String.class, String.class);
		String First = datas.get("first name");
		String sur = datas.get("surname");
		String Mailid = datas.get("emailid");
		String RMailid = datas.get("re mailid");
		String passw = datas.get("password");
        String Day = datas.get("day");
		String Month = datas.get("month");
		String Year = datas.get("year");
		String gender = datas.get("gender");
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(First);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(sur);
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(Mailid);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(RMailid);
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(passw);
        
        WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
               Select s= new Select(day);
               s.selectByValue(Day);
               WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
               Select s1= new Select(month);
               s1.selectByVisibleText(Month);
               WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
               Select s2= new Select(year);
               s2.selectByValue(Year);
               if(gender.equals("Female")) {
      		    	driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
      		           }else if (gender.equals("Male")) {
      		    	      driver.findElement(By.xpath("(//input[@name='sex'])[2]")).click();
      		                 }else {
      		    	             driver.findElement(By.xpath("(//input[@name='sex'])[3]")).click();
      		    	             Select custom = new Select(driver.findElement(By.name("preferred_pronoun")));
      		    	              custom.selectByIndex(3);
      		                           }
                            
        	}
	
	
	@Given("enter user details {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void enter_user_details(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) throws InterruptedException {
		String First = string;
		String sur = string2;
		String Mailid = string3;
		String RMailid = string4;
		String passw = string5;
        String Day = string6;
		String Month = string7;
		String Year = string8;
		String gender=  string9;
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(First);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(sur);
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(Mailid);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(RMailid);
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(passw);
        
        WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
               Select s= new Select(day);
               s.selectByValue(Day);
               WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
               Select s1= new Select(month);
               s1.selectByVisibleText(Month);
               WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
               Select s2= new Select(year);
               s2.selectByValue(Year);
               if(gender.equals("Female")) {
   		    	driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
   		           }else if (gender.equals("Male")) {
   		    	      driver.findElement(By.xpath("(//input[@name='sex'])[2]")).click();
   		                 }else {
   		    	             driver.findElement(By.xpath("(//input[@name='sex'])[3]")).click();
   		    	             Select custom = new Select(driver.findElement(By.name("preferred_pronoun")));
   		    	              custom.selectByIndex(3);
   		                           }
               
               
               
	}
	
	
	}
	
	
	
	
	
	
	
	
	


	


