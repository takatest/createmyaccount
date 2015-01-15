package Usermanagement;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateMyacountPage {
	public void enterMyaccount(WebDriver driver, String myaccount,
			String password, String country) {

		driver.findElement(By.linkText("Create a new My Account")).click();
		driver.findElement(By.id("accounttype10")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(
				"takashi.komuro@melbourneit.com.au");
		driver.findElement(By.name("fname")).clear();
		driver.findElement(By.name("fname")).sendKeys("test");
		driver.findElement(By.name("sname")).clear();
		driver.findElement(By.name("sname")).sendKeys("taka");
		new Select(driver.findElement(By.id("dobday")))
				.selectByVisibleText("1");
		new Select(driver.findElement(By.id("dobmonth")))
				.selectByVisibleText("02 (February)");
		driver.findElement(By.name("dobyear")).clear();
		driver.findElement(By.name("dobyear")).sendKeys("1988");

		if (country.equals("AU")) {
			new Select(driver.findElement(By.name("country")))
					.selectByVisibleText("Australia");
			new Select(driver.findElement(By.id("state")))
					.selectByVisibleText("Victoria");
			driver.findElement(By.id("suburb")).clear();
			driver.findElement(By.id("suburb")).sendKeys("Melbourne");
			driver.findElement(By.id("postcode")).clear();
			driver.findElement(By.id("postcode")).sendKeys("3000");
			driver.findElement(By.id("address1")).clear();
			driver.findElement(By.id("address1")).sendKeys("649 Latrobe st");
			driver.findElement(By.id("phone")).clear();
			driver.findElement(By.id("phone")).sendKeys("+61.1112233");
		} else if (country.equals("US")) {
			new Select(driver.findElement(By.name("country")))
					.selectByVisibleText("United States of America");
			new Select(driver.findElement(By.id("state")))
					.selectByVisibleText("New York");
			driver.findElement(By.id("suburb")).clear();
			driver.findElement(By.id("suburb")).sendKeys("new yok");
			driver.findElement(By.id("postcode")).clear();
			driver.findElement(By.id("postcode")).sendKeys("90210");
			driver.findElement(By.id("address1")).clear();
			driver.findElement(By.id("address1")).sendKeys("12233");
			driver.findElement(By.id("phone")).clear();
			driver.findElement(By.id("phone")).sendKeys("+1.1112233");
		}

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(myaccount);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("password2")).clear();
		driver.findElement(By.id("password2")).sendKeys(password);
		driver.findElement(By.id("challengea")).clear();
		driver.findElement(By.id("challengea")).sendKeys("takashik");
		driver.findElement(By.id("tandc")).click();
		driver.findElement(By.id("acomm")).click();
		driver.findElement(By.id("submit")).click();

		Boolean isPresent = driver.findElements(
				By.xpath("//dl[@id='error']/dd")).size() > 0;
		System.out.println("ispresent >>" + isPresent);
		
/*		// if my account already exists
		if (isPresent == true) {
			System.out.println("This user already exists");
		} else {
			System.out.println("new My account");

		}

		try {
			driver.findElement(By.xpath("//dl[@id='error']/dd")).equals("This username already exists. Please try again.");
			
		}catch(NoSuchElementException e){
			System.out.println("This user already exits");
		}
		
		/*
		 * if
		 * (driver.findElement(By.xpath("//dl[@id='error']/dd")).getText().equals
		 * ("This username already exists. Please try again.")){
		 * System.out.println("This user already exits"); }
		 */

	}

}
