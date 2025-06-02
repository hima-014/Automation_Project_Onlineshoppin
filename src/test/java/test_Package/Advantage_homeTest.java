package test_Package;

import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.annotations.Test;

import base_Package.Advantage_base;

public class Advantage_homeTest extends Advantage_base{
WebDriverWait wait;
@Test(priority=3)
public void Sel_Test() throws InterruptedException {
	waitForPageToBeReady();
	int link = home.getNumberOfLinks();
	System.out.println("The no.of links in this page is "+link);
	home.select_Product();
	
}
@Test(priority =4)
public void title_Test() {
	waitForPageToBeReady();
	String exptext = home.titleVerification();	
	System.out.println("*"+exptext+"*");
	String actualText = " Advantage Shopping";
	Assert.assertEquals(actualText, exptext);
}
}
