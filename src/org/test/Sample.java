package org.test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample {

	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Senthil\\eclipse-workspace\\May5\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void afterClass() {
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterMethod
	public void afterMethod() {
		Date d = new Date();
		System.out.println(d);
	}

	@Test
	public void test() {
		Assert.assertTrue(driver.getTitle().contains("Create your Google Account"),"verify title");
		Assert.assertTrue(driver.getCurrentUrl().contains("accounts"),"verify url");
		
		WebElement firstname = driver.findElement(By.id("firstName"));
		firstname.sendKeys("uma");
		Assert.assertEquals("uma", firstname.getAttribute("value"),"verify firstname");
		System.out.println(firstname.getAttribute("value"));
		
		WebElement lastname = driver.findElement(By.id("lastName"));
		lastname.sendKeys("thiru");
		Assert.assertEquals("thiru", lastname.getAttribute("value"),"verify lastname");
		System.out.println(lastname.getAttribute("value"));
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("umathirukumar");
		Assert.assertEquals("umathirukumar", username.getAttribute("value"));
		System.out.println(username.getAttribute("value"));
		
		WebElement password = driver.findElement(By.name("Passwd"));
		password.sendKeys("####");
		Assert.assertEquals("####", password.getAttribute("value"));
		System.out.println(password.getAttribute("value"));
		
		WebElement confirm = driver.findElement(By.name("ConfirmPasswd"));
		confirm.sendKeys("####");
		Assert.assertEquals("####", confirm.getAttribute("value"));
		System.out.println(confirm.getAttribute("value"));

		WebElement btn = driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
		btn.click();

	}

}
