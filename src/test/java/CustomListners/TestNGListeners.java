package CustomListners;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;

public class TestNGListeners implements ITestListener,IInvokedMethodListener,IExecutionListener//,IRetryAnalyzer
{

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" failed");
        // 1. Get the driver from the current test instance
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        // 2. Take the screenshot
        if (driver != null) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // 3. Define destination (e.g., screenshots/testName.png)
            String screenshotName = result.getName() + ".png";
            File destFile = new File("screenshots/" + screenshotName);

            try {
                FileUtils.copyFile(srcFile, destFile);
                System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Skipped");
    }
    ///////////////////////////////////////////////////////////////////////////////
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println(method.getTestMethod().getMethodName()+" Started");
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println(method.getTestMethod().getMethodName()+" Finished");
    }
    ///////////////////////////////////////////////////////////////////////////////
    public void onExecutionStart() {
        System.out.println("OnExecutionStart");
    }

    public void onExecutionFinish() {
        System.out.println("OnExecutionStartEnd");

    }
    ///////////////////////////////////////////////////////////////////////////////
//    private boolean attemps=false;
//    @Override
//    public boolean retry(ITestResult iTestResult) {
//        if(iTestResult.getStatus()==ITestResult.FAILURE && !attemps){
//            attemps=true;
//            return true;
//        }
//        return false;
//    }
    ///////////////////////////////////////////////////////////////////////////////


}
