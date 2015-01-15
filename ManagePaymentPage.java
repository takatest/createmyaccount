package Usermanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import RegisterdomainName.Page;

public class ManagePaymentPage extends Page {
	public void enterPaymentDetail(WebDriver driver) {
		
		waitForAWhile(6000);

		driver.findElement(By.linkText("Manage Payment Details")).click();
	    driver.findElement(By.id("add")).click();
	    driver.findElement(By.cssSelector("label.active")).click();
	    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
	    driver.findElement(By.id("cardname")).clear();
	    driver.findElement(By.id("cardname")).sendKeys("test");
	    new Select(driver.findElement(By.id("cardtype"))).selectByVisibleText("Visa Card");
	    driver.findElement(By.id("cardnumber")).clear();
	    driver.findElement(By.id("cardnumber")).sendKeys("4111111111111111");
	    new Select(driver.findElement(By.id("cardexpmonth"))).selectByVisibleText("01 (January)");
	    new Select(driver.findElement(By.id("cardexpyear"))).selectByVisibleText("2018");
	    driver.findElement(By.id("cardverificationcode")).clear();
	    driver.findElement(By.id("cardverificationcode")).sendKeys("123");
	    driver.findElement(By.name("submit")).click();
	    driver.findElement(By.linkText("My Account")).click();
	}
}
