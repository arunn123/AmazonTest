package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Firstwindow {

	public static WebDriver wd = null;
	public static String mobiletext;
	public static String pricetextnew;
	public static String mobiletextcart;
	public static String pricetextcartnew;
	public static File f = null;
	public static FileInputStream fis = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;

	public static void launch_the_Amazon_URL() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Arun\\eclipse-workspace\\BDD_AmazonTest\\browser\\chromedriver.exe");
		wd = new ChromeDriver();

		wd.manage().window().maximize();
		wd.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get("https://www.amazon.in/");
		wd.manage().deleteAllCookies();

	}

	public static void user_enters_product_name_by_choosing_category_and_hit_search() throws IOException {
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	}

	public static void list_of_products_should_be_displayed_with_product_name_and_price() throws IOException {
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("C:\\Users\\Arun\\eclipse-workspace\\BDD_AmazonTest\\Screenshot\\product.jpg"));
	}

	public static void user_clicks_on_first_displayed_mobile_result() {
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	}
}
