package utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecification;

public class Listerner1 extends ProjectSpecification implements ITestListener {
	ExtentTest test;
	 ExtentReports extents= Extent.getreport();
	@Override
	public void onTestStart(ITestResult result) {
	test=extents.createTest(result.getMethod().getMethodName());
	System.out.println("Test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("testpassed");
		System.out.println("Test succeed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		System.out.println("Test failure");
		String filepath=null;;
		try {
			filepath = getscreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		extents.flush();
	}

}
