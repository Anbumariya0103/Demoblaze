package utility;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utilityclass1 {
	 public static WebDriver driver;
	 public String excelfile; 
	public void launchbrowser(String browser, String url) {
	 ChromeOptions option=new ChromeOptions();
	  option.addArguments("--disable-notifications");
	  if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver(option);}
	  else if(browser.equalsIgnoreCase("edge")){
		  driver=new EdgeDriver();
	  }
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		}

	public static String[][] readExcel(String excelfile) throws IOException {
		  
		  XSSFWorkbook book=new XSSFWorkbook("./data1/"+excelfile+".xlsx");
			XSSFSheet sheet = book.getSheetAt(0);
			int rowcount = sheet.getLastRowNum(); 
			short columnCount = sheet.getRow(0).getLastCellNum(); 
			
			String [][] data= new String[rowcount][columnCount]; 
			for (int i = 1; i <= rowcount; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < columnCount; j++) {
					XSSFCell cell = row.getCell(j);
					data[i-1][j]=cell.getStringCellValue();   
					
				}
			}
			book.close();
			return data;
	  }


	public void click (WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public void sendKeys(WebElement ele, String value) {
		
		ele.sendKeys(value);
	}
	
	public String getscreenshot(String testmethodname) throws IOException {
		String path ="./snap/"+testmethodname+".png";
		TakesScreenshot srcshot = ((TakesScreenshot) driver);
		 File source =srcshot.getScreenshotAs(OutputType.FILE);
		 File dest= new File(path);
		 FileUtils.copyFile(source, dest);
		 return path;
	}
	public void alert() {
	driver.switchTo().alert().accept();}
	public void closebrowser() {
		driver.close();

	}}

