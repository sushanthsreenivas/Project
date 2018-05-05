package com.oaa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBuyerLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.gecko.driver", "/opt/softwares/geckodriver");
		

		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/OAA");
		Thread.sleep(2000);
		WebElement link;
		link = driver.findElement(By.linkText("Login"));
		link.click();
		Thread.sleep(1000);
		WebElement emailBox,passwdBox;
		emailBox = driver.findElement(By.id("email"));
		emailBox.sendKeys("sahanagb@gmail.com");
		
		emailBox = driver.findElement(By.id("passwd"));
		emailBox.sendKeys("sahana");
		Thread.sleep(1000);
		WebElement form = driver.findElement(By.id("loginForm"));
		form.submit();
		
		Thread.sleep(5000);
		driver.quit();

	}

}
