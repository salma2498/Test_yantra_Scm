package com.scmflex.Genericutils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClass implements ITestListener {
	//WebDriverUtils wb = new WebDriverUtils();
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName + "-----Testscript execution starts from here----");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName + "------->PASSED");
		Reporter.log(MethodName + "-------Testscript executed successfully---");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String FS = result.getMethod().getMethodName();
		String failedScript = FS + new JavaUtils().SystemDateInFormat();
		test.addScreenCaptureFromPath(failedScript);
		try {
			WebDriverUtils.getScreenShot(BaseClass.sdriver, FS);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, failedScript + "------>Failed");
		Reporter.log(failedScript + "---->Test script execution failed ----");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName + "---Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName + "-------");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SCM");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("SCMFLEX");

	    report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("url", "http://rmgtestingserver/domain/Supply_Chain_Management/");
		report.setSystemInfo("Reporter Name", "Umme Salma M");
	}

	@Override
	public void onFinish(ITestContext context) {
		// Consolidate
		report.flush();

	}

}
