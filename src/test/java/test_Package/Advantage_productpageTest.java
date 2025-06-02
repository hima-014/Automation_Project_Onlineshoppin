package test_Package;

import java.io.IOException;

import org.testng.annotations.Test;


import base_Package.Advantage_base;

public class Advantage_productpageTest extends Advantage_base{

	@Test(priority = 5)
	public void test_navigation() throws InterruptedException{
		waitForPageToBeReady();
		prod.items();
		
	}
	@Test(priority = 6)
	public void slider() throws InterruptedException {
		waitForPageToBeReady();
		prod.adjustPriceSlider(30, -50);
		prod.DisplaydropDown();
		prod.os_Dropdown();
		//prod.processor_Dropdown();
		//prod.weight_Dropdown();
		//prod.colour_Dropdown();
		prod.select_filteredItem();
		Thread.sleep(1000);
		prod.add_Item_To_Cart();
	}
	@Test(priority = 7)
	public void checkOut() {
		waitForPageToBeReady();
		check.Checkout_cart();
		
	}
	/*@Test(priority = 8)
	public void paymentWindow() {
		waitForPageToBeReady();
		check.payment();
		}*/
	@Test(priority=8)
	public void pay_n_Print() throws IOException, InterruptedException {
		
		check.click_Paynow();
		Thread.sleep(2000);
		check.screenshot();
	}
	
}
