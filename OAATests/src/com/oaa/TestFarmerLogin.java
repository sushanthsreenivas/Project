package com.oaa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFarmerLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "/media/sahana/608498A7849880E8/Softwares/geckodriver");
		

		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/OAA");
		Thread.sleep(2000);
		WebElement link;
		link = driver.findElement(By.linkText("Login"));
		link.click();
		Thread.sleep(1000);
		WebElement emailBox;
		emailBox = driver.findElement(By.id("email"));
		emailBox.sendKeys("sahana@gmail.com");
		
		emailBox = driver.findElement(By.id("passwd"));
		emailBox.sendKeys("kavyapatil");
		Thread.sleep(1000);
		WebElement form = driver.findElement(By.id("loginForm"));
		form.submit();
		
		Thread.sleep(3000);
		//driver.quit();
	}

}
