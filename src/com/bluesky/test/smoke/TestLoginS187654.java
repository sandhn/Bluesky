package com.bluesky.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bluesky.object.ui.LoginPage;
import com.bluesky.utils.CreateDriver;

public class TestLoginS187654
{
	WebDriver driver;
	LoginPage login;
	@BeforeMethod
	public void preCOndition()
	{
		driver = CreateDriver.getDriverInstance();
		login = new LoginPage(driver);
	}
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	@Test
	public void testLoginInvalidTC197543()
	{
		// Wait for login page to load
		login.waitForLoginPageToLoad();
		// Get title and verify title of webpage
		String actualTitle = driver.getTitle();
		String expectedTitle = "actiTIME - Login";
		Assert.assertEquals(actualTitle, expectedTitle);
		// Enter valid username
		login.getUsernameTextbox().sendKeys("admin");
		// Enter invalid password
		login.getPasswordTextbox().sendKeys("Invalid");
		// Click on Login
		login.getLoginButton().click();
		// Get error msg and Verify
		String actualErrorMsg = login.getLoginErrorMsg().getText();
		String expectedErrorMsg = 
				"Username or Password is invalid. Please try again.";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}
}
