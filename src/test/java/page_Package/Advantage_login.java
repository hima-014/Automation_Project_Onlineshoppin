package page_Package;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Advantage_login {
WebDriver driver;
WebDriverWait wait;

@FindBy(id="menuUser")
WebElement click_Menu;

@FindBy(name="username")
WebElement username;

@FindBy(name="password")
WebElement password;

@FindBy(id="sign_in_btn")
WebElement sign_in;

public Advantage_login(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
}

public void menu_Sel() {
	wait.until(ExpectedConditions.elementToBeClickable(click_Menu)).click();
    wait.until(ExpectedConditions.visibilityOf(username)); 
}
public void setCredentials(String uname,String pswd) {
	wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(uname);
	password.sendKeys(pswd);
}

public void login_click() {
	wait.until(ExpectedConditions.elementToBeClickable(sign_in)).click();
}

public void clear_field() throws InterruptedException {
	
	wait.until(ExpectedConditions.visibilityOf(username));
	username.clear();

	wait.until(ExpectedConditions.visibilityOf(password));
	password.clear();
}

}
