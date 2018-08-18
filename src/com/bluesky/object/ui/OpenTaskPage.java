package com.bluesky.object.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenTaskPage 
{
	WebDriver driver;
	public OpenTaskPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getAddNewTaskButton()
	{
		return driver.findElement(By.xpath("//input[@value='Add New Tasks']"));
	}
	public void waitForOpenTaskToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.id("container"))));
	}
	public List<WebElement> getSuccessMsgs()
	{
		List<WebElement> msgs = 
				driver.findElements(By.className("successmsg"));
		return msgs;
	}
}
