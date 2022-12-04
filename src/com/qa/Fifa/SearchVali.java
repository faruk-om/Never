package com.qa.Fifa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchVali {

	WebDriver driver;

	@Test
	public void vaidateSearch() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Fifa World Cup 2022");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		WebElement firstlink = driver.findElement(By.xpath("(//div[@class='ofy7ae'])[1]"));
		String actualText = firstlink.getText();
		String expected = "FIFA World Cup Qatar 2022™";
		Assert.assertTrue(actualText.equalsIgnoreCase(expected), 
				"Expected" + expected + "butfound >>" + actualText);

	}

}
