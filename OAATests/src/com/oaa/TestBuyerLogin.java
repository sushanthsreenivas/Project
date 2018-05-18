package com.oaa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBuyerLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "/opt/softwares/geckodriver");
		
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.privatebrowsing.autostart", true);

		WebDriver driver = new FirefoxDriver(options);

		driver.get("http://localhost:8080/OAA");
		Thread.sleep(1000);
		WebElement link;
		link = driver.findElement(By.linkText("Login"));
		link.click();
		Thread.sleep(1000);
		WebElement emailBox, passwdBox;
		emailBox = driver.findElement(By.id("email"));
		emailBox.sendKeys("anushkapatil@gmail.com");

		emailBox = driver.findElement(By.id("passwd"));
		emailBox.sendKeys("sahana");
		Thread.sleep(1000);
		WebElement form = driver.findElement(By.id("loginForm"));
		form.submit();

		Thread.sleep(5000);

	}

}
