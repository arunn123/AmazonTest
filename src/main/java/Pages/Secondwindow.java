package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Secondwindow extends Firstwindow {

	public static void chosen_mobile_should_open_in_new_window_with_its_details_and_the_user_reads_the_item_and_price() {

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mobiletext = wd.findElement(By.id("productTitle")).getText();
		String pricetext = wd.findElement(By.id("priceblock_dealprice")).getText();
		pricetextnew = pricetext.replaceAll("[^a-zA-Z0-9,.00]", "");
		System.out.println(mobiletext);
		System.out.println(pricetextnew);
	}

	public static void hit_on_add_to_cart() throws InterruptedException {

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement addtocart = wd.findElement(By.id("add-to-cart-button"));
		addtocart.click();
	}

	public static void user_clicks_on_cart_to_view_cart_details() {

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement cart = wd.findElement(By.id("attach-sidesheet-view-cart-button"));
		cart.click();

	}

	public static void mobile_name_and_price_should_be_displayed_and_validated_by_user() {

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement mobiletext2 = wd.findElement(By.xpath("//span[@class='a-size-medium sc-product-title']"));
		mobiletextcart = mobiletext2.getText();
		WebElement pricetext2 = wd
				.findElement(By.xpath("//div[@class='a-column a-span2 a-text-right a-span-last']/p/span"));
		String pricetextcart = pricetext2.getText();
		pricetextcartnew = pricetextcart.replaceAll(" ", "");
		System.out.println(mobiletextcart);
		System.out.println(pricetextcartnew);
		if (mobiletext.equalsIgnoreCase(mobiletextcart)) {
			System.out.println("Mobile text validated");
			if (pricetextnew.contains(pricetextcartnew)) {
				System.out.println("Mobile price validated");
			} else {
				System.out.println("Price data mismatch");
			}
		} else {
			System.out.println("Text data mismatch");
		}

	}

	public static void the_user_places_the_order_by_clicking_proceed_to_checkout() {
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement proceedtobuy = wd.findElement(By.name("proceedToRetailCheckout"));
		proceedtobuy.click();
	}

	public static void user_enters_the_login_details() {
		WebElement loginemail = wd.findElement(By.name("email"));
		sheet = workbook.getSheet("UserCredentials");
		int row1 = sheet.getLastRowNum() + 1;
		int cell1 = sheet.getRow(0).getLastCellNum();
		System.out.println(row1);
		System.out.println(cell1);
		String data = sheet.getRow(0).getCell(0).getStringCellValue();
		String data2 = sheet.getRow(1).getCell(0).getStringCellValue();
		loginemail.sendKeys(data, Keys.ENTER);
		WebElement password = wd.findElement(By.name("password"));
		password.sendKeys(data2, Keys.ENTER);

	}

	public static void user_chooses_delivery_address_and_continue_to_payment() {
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement deliveryaddress = wd.findElement(By.xpath("//a[contains(text(),'Deliver to this address')]"));
		deliveryaddress.click();
		WebElement radiobutton = wd.findElement(
				By.xpath("//input[@id='order_0_ShippingSpeed_std-in-cod-eligible' and @class=' shipping-option']"));
		radiobutton.click();
		wd.findElement(By.xpath(
				"//span[@class='a-button-inner']/child::input[@type='submit' and @class='a-button-text' or @value='Continue']"))
				.click();
		WebElement payment = wd.findElement(By.xpath(
				"/html/body/div[5]/div[1]/div[2]/div[2]/div/div[2]/div[1]/form/div[1]/div/div/div/div[5]/div/div/div/div[1]/span/div/label/input"));
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("arguments[0].click()", payment);
	}

	public static void user_removes_product_from_cart() {
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.navigate().back();
		wd.findElement(By.xpath("//a[contains(@class,'pipeline-link')]")).click();
		wd.findElement(By.cssSelector(
				"div.checkout.checkout-itemselect.desktop.locale-in.checkout-itemselect-desktop:nth-child(2) div.a-container form.checkout-page-form div.a-row.a-spacing-base.item-row:nth-child(4) div.a-column.a-span5:nth-child(2) div.a-fixed-left-grid div.a-fixed-left-grid-inner.image-grid div.a-fixed-left-grid-col.a-col-right.itemselect-right-col:nth-child(2) div.a-spacing-top-mini.no-js-hide:nth-child(5) > a.a-link-normal.a-declarative"))
				.click();
		System.out.println("Item removed successfully");

	}

	public static void user_closes_the_browser() {
		wd.quit();
		System.out.println("Browser closed successfully");
	}
}
