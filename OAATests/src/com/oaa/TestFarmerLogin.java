package com.oaa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestFarmerLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "/opt/softwares/geckodriver");

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffProfile = profile.getProfile("default");
	
		ffProfile.setPreference("browser.privatebrowsing.autostart", true);

		// accept the certificate
		//ffProfile.setAcceptUntrustedCertificates(true);
		//ffProfile.setAssumeUntrustedCertificateIssuer(false);
		capabilities.setCapability(FirefoxDriver.PROFILE, ffProfile);

		WebDriver driver = new FirefoxDriver(capabilities);

		driver.get("http://localhost:8080/OAA");
		Thread.sleep(1000);
		WebElement link;
		link = driver.findElement(By.linkText("Login"));
		link.click();
		Thread.sleep(1000);
		WebElement emailBox, passwdBox;
		emailBox = driver.findElement(By.id("email"));
		emailBox.sendKeys("kavyapatil@gmail.com");

		emailBox = driver.findElement(By.id("passwd"));
		emailBox.sendKeys("krpatil");
		Thread.sleep(1000);
		WebElement form = driver.findElement(By.id("loginForm"));
		form.submit();
		
	}

}
