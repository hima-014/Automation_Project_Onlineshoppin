package test_Package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
import base_Package.Advantage_base;
import utility_Package.Excelutils;


public class Advantage_logintest extends Advantage_base {
	WebDriverWait wait;

   
	@BeforeMethod
	public void setupWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	@Test(priority=1)
	public void menu_Test() throws InterruptedException {
		//driver.get("https://advantageonlineshopping.com/#/");
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader")));
		waitForPageToBeReady(); 
		login.menu_Sel();
	}
	@Test(priority=2)
	public void login_Test() throws InterruptedException {
		//driver.get("https://advantageonlineshopping.com/#/");
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader")));
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader"))); // page loader
		waitForPageToBeReady();
		
		//login.menu_Sel(); // opens the popup
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//login-modal//div[@class='loader']"))); // popup loader
		String xl = "/Users/jithin/Desktop/blaze_Testdata.xlsx";
		String Sheet = "Sheet1";
		int rowCount = Excelutils.getRowCount(xl, Sheet);
		for(int i=0; i<=rowCount; i++) {
		    String userName=Excelutils.getCellValue(xl, Sheet, i, 0);
		    String pswd=Excelutils.getCellValue(xl, Sheet, i, 1);
		    Thread.sleep(2000);
		    login.clear_field();
		    login.setCredentials(userName, pswd);
		    login.login_click();
		    
	}
		
		}
	
}
