package page_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Advantage_Productpage {
WebDriver driver;
WebDriverWait wait;
Actions actions;
JavascriptExecutor js; 
@FindBy(id="menuCart")
WebElement menuCart;

@FindBy(xpath="/html/body/div[3]/section/article/nav/a[1]")
WebElement home;

@FindBy(xpath="//*[@id=\"laptopsTxt\"]")
WebElement laptop;

@FindBy(xpath="//*[@id=\"accordionAttrib0\"]")
WebElement display_Dropdown;

@FindBy(xpath="//h4[@translate='PRICE' and @role='link']")
WebElement slider;

@FindBy(id = "display_4")
WebElement display_Option5;

//====== SLIDER LOCATORS ======
@FindBy(xpath = "//div[@class='noUi-handle noUi-handle-lower']")
WebElement minSlider;

@FindBy(xpath = "//div[@class='noUi-handle noUi-handle-upper']")
WebElement maxSlider;

@FindBy(xpath="//*[@id=\"accordionAttrib1\"]")
WebElement OS;

@FindBy(id="operating_system_1")
WebElement OS_option;
/*
@FindBy(xpath="//*[@id='accordionAttrib2']")
WebElement processor;

@FindBy(id="processor_3")
WebElement processor_Option;

@FindBy(xpath="//*[@id='accordionAttrib3']")
WebElement weight;

@FindBy(id="weight_0")
WebElement weight_Option;

@FindBy(xpath="//*[@id=\"accordionColor\"]")
WebElement colour;

@FindBy(id="productsColors414141")
WebElement colour_Option;
*/
@FindBy(id="10")
WebElement select_FilteredProduct;

@FindBy(xpath="//*[@id=\"productProperties\"]/div[4]/button")
WebElement Add_to_Cart;

public Advantage_Productpage(WebDriver driver) {
	this.driver = driver;
	//this.wait = wait;
	PageFactory.initElements(driver,this);
	wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	actions = new Actions(driver);
	js= (JavascriptExecutor) driver;

}

public void items() throws InterruptedException {
	wait.until(ExpectedConditions.visibilityOf(menuCart)).click();
	wait.until(ExpectedConditions.visibilityOf(home)).click();
	wait.until(ExpectedConditions.visibilityOf(laptop)).click();
	
	
	//js.executeScript("window.scrollBy(200, 700);");
	
	//js.executeScript("arguments[0].scrollIntoView({block: 'center'});",slider);

	/*try {
	    Thread.sleep(500); // Adjust the time as needed
	} catch (InterruptedException e) {
	    Thread.currentThread().interrupt();
	}*/
	//Thread.sleep(1000);
	//wait.until(ExpectedConditions.elementToBeClickable(slider)).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[@translate='PRICE' and @role='link']")));
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", slider);
	wait.until(ExpectedConditions.elementToBeClickable(slider)).click();
	
	
	
}
//FILTERS
public void adjustPriceSlider(int minOffset, int maxOffset) throws InterruptedException {
    
	//Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(minSlider));
    wait.until(ExpectedConditions.visibilityOf(maxSlider));
    actions.dragAndDropBy(minSlider, minOffset, 0).perform();
    //Thread.sleep(1000); // optional wait to visually observe change

    actions.dragAndDropBy(maxSlider, maxOffset, 0).perform();
    Thread.sleep(1000); // optional wait to observe effect
}
public void DisplaydropDown() throws InterruptedException {
	
	wait.until(ExpectedConditions.visibilityOf(display_Dropdown)).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(display_Option5)).click();
}
public void os_Dropdown() {
	wait.until(ExpectedConditions.visibilityOf(OS)).click();
	wait.until(ExpectedConditions.elementToBeClickable(OS_option)).click();
}
public void select_filteredItem() {
	js.executeScript("window.scrollTo(500, 250);");
	wait.until(ExpectedConditions.elementToBeClickable(select_FilteredProduct)).click();
}
public void add_Item_To_Cart() {
	wait.until(ExpectedConditions.elementToBeClickable(Add_to_Cart)).click();
}
/*
public void processor_Dropdown() {
	wait.until(ExpectedConditions.visibilityOf(processor)).click();
	wait.until(ExpectedConditions.elementToBeClickable(processor_Option)).click();
}
public void weight_Dropdown() {
	wait.until(ExpectedConditions.visibilityOf(weight)).click();
	wait.until(ExpectedConditions.elementToBeClickable(weight_Option)).click();
}
public void colour_Dropdown() throws InterruptedException {
	wait.until(ExpectedConditions.visibilityOf(colour)).click();
	wait.until(ExpectedConditions.elementToBeClickable(colour_Option)).click();
	Thread.sleep(1000);
	js.executeScript("window.scrollTo(500, 250);");
}*/
}