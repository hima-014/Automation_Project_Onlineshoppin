package base_Package;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import page_Package.Advantage_Productpage;
import page_Package.Advantage_login;
import page_Package.Advantage_Checkoutpage;
import page_Package.Advantage_Homepage;

public class Advantage_base {
    public static WebDriver driver;
    protected WebDriverWait wait;
    protected Advantage_login login;
    protected Advantage_Homepage home;
    protected Advantage_Productpage prod;
    protected Advantage_Checkoutpage check;

    @BeforeTest
    public void open_Browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://advantageonlineshopping.com/#/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       
        waitForPageToBeReady();
    }  

    @BeforeClass
   public void set_Up() {
        login = new Advantage_login(driver);
        home = new Advantage_Homepage(driver);
        prod = new Advantage_Productpage(driver);
        check= new Advantage_Checkoutpage(driver);  
        }
    
 // Master wait method
    public void waitForPageToBeReady() {
        try {
            // Wait for general loader to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader")));

            // Wait for login modal (if any) to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//login-modal//div[contains(@class,'loader')]")));

            // Wait until main user icon is actually clickable
            wait.until(ExpectedConditions.elementToBeClickable(By.id("menuUser")));

        } catch (Exception e) {
            System.out.println("Wait failed: " + e.getMessage());
        }
    }
}
/*package base_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import page_Package.Advantage_Productpage;
import page_Package.Advantage_login;
import page_Package.Advantage_Homepage;

public class Advantage_base {
public static WebDriver driver;
protected Advantage_login login;
protected Advantage_Homepage home;
protected Advantage_Productpage prod;


@BeforeTest
public void open_Browser() {
driver= new ChromeDriver();
driver.get("https://advantageonlineshopping.com/#/");
driver.manage().window().maximize();

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader")));
wait.until(ExpectedConditions.elementToBeClickable(By.id("menuUser")));
}
public void waitForLoaderToDisappear() {
    WebDriverWait loaderWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    try {
        loaderWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader")));
    } catch (Exception e) {
        System.out.println("Loader not found or already gone.");
    }
}
@BeforeClass
public void set_Up() {
	
	login = new Advantage_login(driver);
	home = new Advantage_Homepage(driver);
	prod = new Advantage_Productpage(driver);
}
}
*/