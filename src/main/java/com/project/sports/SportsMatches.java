package com.project.sports;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SportsMatches {

	public static void main(String[] args) {
		
		By matches = By.xpath("//*[@class='qa-match-block']/h3");
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bbc.co.uk/sport/football/scores-fixtures");
		driver.manage().window().maximize();
		System.out.println("Page Title: "+driver.getTitle());
		
		String header = driver.findElement(By.xpath("//*[text()='Football Scores & Fixtures']")).getText();
		Assert.assertTrue(header!=null, "Navigation to home page unsuccessful");
		
		if(!matches.toString().isEmpty())
		{
			List<WebElement> matchesList = driver.findElements(By.xpath("//*[@class='qa-match-block']/h3"));
			for(int i =0;i<matchesList.size();i++)
			{
				String txtMatches = matchesList.get(i).getText();
				System.out.println("List of matches for today : " +txtMatches);
			}
		}
		else
		{
			System.out.println("There are no matches scheduled for today.");
		}
		
		List<WebElement> teamsList = driver.findElements(By.xpath("//abbr[@title]"));
		for(int i =0;i<teamsList.size();i++)
		{
			String txtTeams = teamsList.get(i).getAttribute("title");
			System.out.println("List of teams playing today : " +txtTeams);
		}
		
		driver.close();
	}

}
