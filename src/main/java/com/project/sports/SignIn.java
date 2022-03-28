package com.project.sports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignIn {

	public static void main(String[] args) {
		
		By btn_SignIn = By.xpath("//*[text()='Sign in]");
		By txt_UserName = By.xpath("//*[@name='username']");
		By txt_Password = By.xpath("//*[@name='password']");
		By btn_LogIn = By.xpath("//*[@id='submit-button']");
		
		//Set Chrome Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		//Launch URL
		driver.get("https://www.bbc.co.uk/sport/football/scores-fixtures");
		driver.manage().window().maximize();
		System.out.println("Page Title: "+driver.getTitle());
		
		driver.findElement(btn_SignIn).click();
		driver.findElement(txt_UserName).sendKeys("swejr@g.com");
		driver.findElement(txt_Password).sendKeys("passwordsample@2022");
		driver.findElement(btn_LogIn).click();
		
		String errorMsg = driver.findElement(By.xpath("//*[contains(@class, 'form-message__text')]//span/span")).getText();
		System.out.println("Error message post login: "+errorMsg);
	}

}
