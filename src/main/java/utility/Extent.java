package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent {
	public static ExtentReports getreport() {
		ExtentSparkReporter extent=new ExtentSparkReporter("./reports1/report.html");
	extent.config().setReportName("Demoblaze");
	extent.config().setDocumentTitle("Demoblazetitle");
	
	ExtentReports report= new ExtentReports();
	report.attachReporter(extent);
	return report;

}
}
