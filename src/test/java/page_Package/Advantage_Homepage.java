package page_Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Advantage_Homepage {
WebDriver driver;
WebDriverWait wait;
JavascriptExecutor js;

@FindBy(tagName="a")
private List<WebElement> allLinks;

@FindBy(id="speakersImg")
WebElement item_Speaker;

@FindBy(id="25")
WebElement speaker_Bose;

@FindBy(xpath="//button[@name='save_to_cart']")
WebElement cart_Add;

public Advantage_Homepage(WebDriver driver) {
	this.driver = driver;
	//this.wait=wait;
	PageFactory.initElements(driver,this);
	wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	js = (JavascriptExecutor) driver;
}

public int getNumberOfLinks() {
    return allLinks.size();
}

public String titleVerification () {
	String text=driver.getTitle();
	return text;
}

public void select_Product() {
	//js.executeScript("arguments[0].scrollIntoView(true)",item_Speaker);
	wait.until(ExpectedConditions.visibilityOf(item_Speaker)).click();
	//js.executeScript("window.scrollBy(0, 250);");
	//wait.until(ExpectedConditions.visibilityOf(speaker_Bose)).click();
	//wait.until(ExpectedConditions.visibilityOf(cart_Add)).click();
	wait.until(ExpectedConditions.visibilityOf(speaker_Bose));
    js.executeScript("arguments[0].scrollIntoView(true);", speaker_Bose);
    js.executeScript("window.scrollBy(0, -100);"); // Adjust scroll to avoid headers
    wait.until(ExpectedConditions.elementToBeClickable(speaker_Bose)).click();

    // Wait and click 'Add to Cart'
    wait.until(ExpectedConditions.visibilityOf(cart_Add));
    wait.until(ExpectedConditions.elementToBeClickable(cart_Add)).click();
	
}
}
