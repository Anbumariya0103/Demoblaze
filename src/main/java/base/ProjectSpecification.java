package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utility.Utilityclass1;

public class ProjectSpecification extends Utilityclass1 {
	
	  @Parameters({"browser","url"})
	  @BeforeMethod
	  public void browserLaunch(String browser, String url) {
		  
		  launchbrowser(browser, url);
		  
	  }
		
		@DataProvider(name = "getData")
		public String[][] getData() throws IOException {
			
			String[][] data = readExcel(excelfile);
			return data;
		}
	  
	 // @AfterMethod  
	  //public void closeBrowser() { 
		  
	  }
	//}



