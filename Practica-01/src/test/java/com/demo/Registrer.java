package com.demo;

import util.BaseTest;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Registrer extends BaseTest {
	@Test
	public void clickRegister() throws InterruptedException {
		driver.findElement(By.className("ico-register")).click();
		assertTrue(driver.findElement(By.className("page-title")).isDisplayed());

		driver.findElement(By.className("female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Luis");
		driver.findElement(By.id("LastName")).sendKeys("Gómez");

		// Selects: se utiliza la clase Select de Java
		Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
		day.selectByValue("21");

		Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		month.selectByVisibleText("March");

		Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
		year.selectByValue("1974");

		driver.findElement(By.id("Email")).sendKeys("ana.molina07@gmail.com");

		if (driver.findElement(By.id("Newsletter")).isSelected()) {
			driver.findElement(By.id("Newsletter")).click();
		}
		
		driver.findElement(By.id("Password")).sendKeys("Password123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Password123");
	
		//Thread.sleep(10000);
		
		driver.findElement(By.id("register-button")).submit();
	}
	
	@Test
	public void logIn() {
		driver.findElement(By.className("ico-login")).click();
		assertEquals(driver.getTitle(),"nopCommerce demo store. Login");
		
		driver.findElement(By.id("Email")).sendKeys("ana.molina07@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Password123");
		
		driver.findElement(By.className("login-button")).submit();
		
		assertTrue(driver.findElement(By.className("ico-account")).isDisplayed());
		assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed());
		
	}

}
