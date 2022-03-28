package com.project.sports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchSports {

	public static void main(String[] args) {
		By btn_Search = By.xpath("//*[contains(@title, 'Search BBC)]");
		By txt_Search = By.xpath("//*[contains(@id, 'se-searchbox-input-field')]");
		By icon_Search = By.xpath("//*[contains(@class, 'se-searchbox__submit')]");
		
		//Set Chrome Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		//Launch URL
		driver.get("https://www.bbc.co.uk/sport/football/scores-fixtures");
		driver.manage().window().maximize();
		System.out.println("Page Title: "+driver.getTitle());
		
		String header = driver.findElement(By.xpath("//*[text()='Football Scores & Fixtures']")).getText();
		Assert.assertTrue(header != null, "Navigation to home page unsuccessful");
		
		driver.findElement(btn_Search).click();
		WebDriverWait wait = new WebDriverWait(driver, null);
		
		driver.findElement(txt_Search).sendKeys("sports");
		driver.findElement(icon_Search).click();
		
		String firstSearchRes = driver.findElement(By.xpath("//*[@id='main-content']//following::a//p//span)[1])")).getText();
		String lastSearchRes = driver.findElement(By.xpath("//*[@id='main-content']//following::a//p//span)[10])")).getText();
		System.out.println("First and Last Search Results: "+ firstSearchRes + "<br/>" + lastSearchRes);
		
		driver.close();

	}

}
