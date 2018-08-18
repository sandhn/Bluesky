package com.bluesky.object.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewTaskPage
{
	WebDriver driver;
	public AddNewTaskPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getCustomerDropDownList()
	{
		return driver.findElement(By.name("customerId"));
	}
	public WebElement getNewCustomerTextbox()
	{
		return driver.findElement(By.name("customerName"));	
	}
	public WebElement getProjectNameTextbox()
	{
		return driver.findElement(By.name("projectName"));
	}
	public WebElement getTaskNameTextboxOne()
	{
		return driver.findElement(By.name("task[0].name"));
	}
	public WebElement getCreateTaskButton()
	{
		return driver.findElement(By.
				xpath("//input[@value='Create Tasks']"));
	}
	public void waitForAddNewTaskPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.id("container"))));
	}
}
