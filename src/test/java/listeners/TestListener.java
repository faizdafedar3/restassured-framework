package listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = "test-output/ExtentReport_" + timestamp + ".html";

        ExtentSparkReporter spark = new ExtentSparkReporter(new File(reportPath));
        spark.config().setReportName("API Automation Report");
        spark.config().setDocumentTitle("Rest Assured Framework");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Tester", "Faiz");
        extent.setSystemInfo("Framework", "Rest Assured + TestNG");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
