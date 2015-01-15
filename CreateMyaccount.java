package Usermanagement;

import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import RegisterdomainName.LogoutPage;

//create my account
public class CreateMyaccount {

	private FirefoxDriver 					driver;					// firefox driver
	private String 							password;				// my account password	property
    
    private static CreateMyacountPage 		CreateMyacountPage;		// Create My account page
    private static ManagePaymentPage		ManagePaymentPage;		// Manage Payment Page
    private static LogoutPage				logOutPage;				// Log out page
    
	private String baseUrl = "https://stage.melbourneit.com.au/";		//URL stage
//	private Sstring baseUrl = "https://www.melbourneit.com.au/";		//URL prod
    
	@BeforeTest
	public void BeforeTest() {
		 driver = new FirefoxDriver();
//			driver.get(baseUrl); 
		 
	    // create page object
		CreateMyacountPage = new CreateMyacountPage();
        logOutPage = new LogoutPage();
        ManagePaymentPage = new ManagePaymentPage();
        
        System.out.println("-------------BeforeTest--------------");
	}

	@BeforeMethod
	public void BeforeMethod(){
		driver.get(baseUrl); 
        System.out.println("-------------BeforeMethod--------------");
	}
	
	// set up data
	@DataProvider(name = "MyAcount")
	public static Object[][] domainName() {
		Object[][] data = new Object[2][2];
		String[] country = {"AU","US"};
		
		for (int k = 0; k<2; k++){

			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			String today = formatter.format( new java.util.Date() );
			int unique_num = (int) (Math.random() * 50 + 1);
			String myaccount = "TAKASTAGE" + today + unique_num;

			System.out.println("myaccount =" + myaccount);
			data[k][0]= country[k];
			data[k][1]= myaccount;
		}
		return data;
	}

/********************************************************************************************
 * 	
 * Create My account test
 * 
 ********************************************************************************************/
	@Test(dataProvider = "MyAcount")
	public void CreateMyaccount(String country, String myaccount){

        System.out.println("-------------"+country+" my account-"+myaccount+"--------------");
	    driver.findElement(By.linkText("Login")).click();

	    password = "password";

	    //Enter My account info
		CreateMyacountPage.enterMyaccount(driver, myaccount, password, country);
		System.out.println("Enter my account end");
		
		//Manage Payment Page
		ManagePaymentPage.enterPaymentDetail(driver);
		System.out.println("Manage Payment end");
		
		// Log out Page
		logOutPage.logout(driver, baseUrl); 
		System.out.println("log out My account");
		System.out.println("------ finished !!---------");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("----------AfterTest----------");
		driver.quit();
	}
}
