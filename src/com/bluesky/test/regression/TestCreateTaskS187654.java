package com.bluesky.test.regression;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bluesky.object.ui.AddNewTaskPage;
import com.bluesky.object.ui.HomePage;
import com.bluesky.object.ui.LoginPage;
import com.bluesky.object.ui.OpenTaskPage;
import com.bluesky.utils.CreateDriver;

public class TestCreateTaskS187654
{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	OpenTaskPage openTask;
	AddNewTaskPage addNewTask;
	@BeforeMethod
	public void preCOndition()
	{
		driver = CreateDriver.getDriverInstance();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		openTask = new OpenTaskPage(driver);
		addNewTask = new AddNewTaskPage(driver);
	}
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	@Test
	public void testCreateTaskTC197566()
	{
		// Wait for Login page
		login.waitForLoginPageToLoad();
		login.getUsernameTextbox().sendKeys("admin");
		login.getPasswordTextbox().sendKeys("manager");
		login.getLoginButton().click();
		// Wait for Home page
		home.waitForHomePageToLoad();
		openTask.waitForOpenTaskToLoad();
		openTask.getAddNewTaskButton().click();
		// Wait for Add new task Page
		addNewTask.waitForAddNewTaskPageToLoad();
		WebElement customerDDL = addNewTask.getCustomerDropDownList();
		Select customersct = new Select(customerDDL);
		customersct.selectByVisibleText("-- new customer --");
		
		addNewTask.getNewCustomerTextbox().sendKeys("Customer001");
		addNewTask.getProjectNameTextbox().sendKeys("Project001");
		addNewTask.getTaskNameTextboxOne().sendKeys("Task001");
		addNewTask.getCreateTaskButton().click();
		
		openTask.waitForOpenTaskToLoad();
		List<WebElement> msgList = openTask.getSuccessMsgs();
		String msg1 = msgList.get(0).getText();
		Assert.assertEquals(msg1.contains("Customer001"), true);
		String msg2 = msgList.get(1).getText();
		Assert.assertEquals(msg2.contains("Project001"), true);
		String msg3 = msgList.get(2).getText();
		Assert.assertEquals(msg3.contains("Task001"), true);
	}
}
