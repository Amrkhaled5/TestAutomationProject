package CustomListners;

import org.testng.*;

public class TestNGListeners implements ITestListener,IInvokedMethodListener,IExecutionListener//,IRetryAnalyzer
{

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" failed");
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
