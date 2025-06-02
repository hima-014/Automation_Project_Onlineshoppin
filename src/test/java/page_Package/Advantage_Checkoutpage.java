package page_Package;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Advantage_Checkoutpage {
WebDriver driver;
WebDriverWait wait;
JavascriptExecutor js;

@FindBy(id="menuCart")
WebElement Click_Add_toCart;

@FindBy(id="checkOutButton")
WebElement checkOut_Button;

@FindBy(id="next_btn")
WebElement CheckOut_next;

@FindBy(xpath = "//input[@name='safepay']")
WebElement safePayRadioOption;

@FindBy(name="safepay_username")
WebElement safePay_uname;

@FindBy(name="safepay_password")
WebElement safePay_password;

@FindBy(id="pay_now_btn_SAFEPAY")
WebElement pay_Now;

//@FindBy(id="pay_now_btn_MasterCredit")
//WebElement pay_Now_MasterCard;

public Advantage_Checkoutpage(WebDriver driver) {
	this.driver = driver;
	//this.wait = wait;
	PageFactory.initElements(driver,this);
	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	js = (JavascriptExecutor) driver;
}
public void Checkout_cart() {
	wait.until(ExpectedConditions.elementToBeClickable(Click_Add_toCart)).click();
	wait.until(ExpectedConditions.elementToBeClickable(checkOut_Button)).click();
	wait.until(ExpectedConditions.elementToBeClickable(CheckOut_next)).click();
}
public void click_Paynow() {
js.executeScript("arguments[0].click();", safePayRadioOption);
safePay_uname.clear();
safePay_password.clear();
wait.until(ExpectedConditions.visibilityOf(safePay_uname)).sendKeys("Jordan");
wait.until(ExpectedConditions.visibilityOf(safePay_password)).sendKeys("Jordan190");
wait.until(ExpectedConditions.visibilityOf(pay_Now)).click();
}
/*
public void click_Paynow() throws InterruptedException {
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(pay_Now_MasterCard)).click();
	}*/
public void screenshot() throws IOException, InterruptedException {
	Thread.sleep(500);
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src, new File("///Users/jithin/Desktop/Screenshot1.png"));
}
}