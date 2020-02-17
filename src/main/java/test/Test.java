package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {
	static WebDriver wd = null;
	static String mobiletext;
	static String pricetextnew;
	static String mobiletextcart;
	static String pricetextcartnew;
	public static File f = null;
	public static FileInputStream fis = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;

	public static void main(String[] args) throws IOException {

		// launch the Amazon URL
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Arun\\eclipse-workspace\\BDD_AmazonTest\\browser\\chromedriver.exe");
		wd = new ChromeDriver();

		wd.manage().window().maximize();
		wd.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get("https://www.amazon.in/");
		wd.manage().deleteAllCookies();

		// user enters product name by choosing category and hit search
		WebElement chooseCategory = wd
				.findElement(By.xpath("//div[@class='nav-search-facade']/following-sibling::select"));
		Select s = new Select(chooseCategory);
		s.selectByValue("search-alias=electronics");
		WebElement productSearch = wd
				.findElement(By.xpath("//input[@id='twotabsearchtextbox' and @name='field-keywords']"));
		f = new File("C:\\Users\\Arun\\eclipse-workspace\\BDD_AmazonTest\\lib\\Book1.xlsx");
		fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Mobilename");
		int row = sheet.getLastRowNum() + 1;
		int cell = sheet.getRow(0).getLastCellNum();
		System.out.println(row);
		System.out.println(cell);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cell; j++) {
				String data = sheet.getRow(i).getCell(j).getStringCellValue();
				productSearch.sendKeys(data, Keys.ENTER);
			}

		}

//		productSearch.sendKeys("oneplus");
//		Actions a = new Actions(wd);
//		a.sendKeys(productSearch, Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

		// list of products should be displayed with product name and price
		File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("C:\\Users\\Arun\\eclipse-workspace\\BDD_AmazonTest\\Screenshot\\product.jpg"));

		// user clicks on first displayed mobile result
		List<WebElement> mobilelist = wd.findElements(By.xpath(
				"//a[@class='a-link-normal a-text-normal']/span[@class='a-size-medium a-color-base a-text-normal']"));
		mobilelist.get(0).click();

		// chosen mobile should open in new window with its details and the user
		// switches to new window
		Set<String> window = wd.getWindowHandles();
		Iterator<String> it = window.iterator();
		while (it.hasNext()) {
			String s1 = it.next();
			wd.switchTo().window(s1);
		}

		// user reads the item name and price
		mobiletext = wd.findElement(By.id("productTitle")).getText();
		String pricetext = wd.findElement(By.id("priceblock_dealprice")).getText();
		pricetextnew = pricetext.replaceAll("[^a-zA-Z0-9,.00]", "");
		System.out.println(mobiletext);
		System.out.println(pricetextnew);

		// hit on add to cart
		WebElement addtocart = wd.findElement(By.id("add-to-cart-button"));
		addtocart.click();

		// user clicks on cart to view cart details
		WebElement cart = wd.findElement(By.id("attach-sidesheet-view-cart-button"));
		cart.click();

		// mobile name and price should be displayed and validated by user
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

		// the user places the order by clicking proceed to checkout
		WebElement proceedtobuy = wd.findElement(By.name("proceedToRetailCheckout"));
		proceedtobuy.click();

		// user enters the login details
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


		// user chooses delivery address and continue to payment
		WebElement deliveryaddress = wd.findElement(By.xpath("//a[contains(text(),'Deliver to this address')]"));
		deliveryaddress.click();
		WebElement radiobutton = wd.findElement(
				By.xpath("//input[@id='order_0_ShippingSpeed_std-in-cod-eligible' and @class=' shipping-option']"));
		radiobutton.click();
		wd.findElement(By.xpath(
				"//span[@class='a-button-inner']/child::input[@type='submit' and @class='a-button-text' or @value='Continue']"))
				.click();

//		WebDriverWait wait = new WebDriverWait(wd,30);
//		WebElement payment=wd.findElement(By.xpath("//input[@id='pp-ZZq2uZ-105' and @name='ppw-instrumentRowSelection']"));
//		wait.until(ExpectedConditions.visibilityOf(payment));
//				payment.click();

//		WebDriverWait wait = new WebDriverWait(wd, 30);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='pp-ZZq2uZ-105']")));
		WebElement payment = wd.findElement(By.xpath(
				"/html/body/div[5]/div[1]/div[2]/div[2]/div/div[2]/div[1]/form/div[1]/div/div/div/div[5]/div/div/div/div[1]/span/div/label/input"));
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("arguments[0].click()", payment);

		// user removes product from cart
		wd.navigate().back();
		wd.findElement(By.xpath("//a[contains(@class,'pipeline-link')]")).click();
		wd.findElement(By.cssSelector(
				"div.checkout.checkout-itemselect.desktop.locale-in.checkout-itemselect-desktop:nth-child(2) div.a-container form.checkout-page-form div.a-row.a-spacing-base.item-row:nth-child(4) div.a-column.a-span5:nth-child(2) div.a-fixed-left-grid div.a-fixed-left-grid-inner.image-grid div.a-fixed-left-grid-col.a-col-right.itemselect-right-col:nth-child(2) div.a-spacing-top-mini.no-js-hide:nth-child(5) > a.a-link-normal.a-declarative"))
				.click();
		System.out.println("Item removed successfully");

	}
}
