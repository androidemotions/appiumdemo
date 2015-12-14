package framework;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import ru.yandex.qatools.allure.annotations.Attachment;

public class ScreenShotListener extends TestListenerAdapter {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
	return screenShot;
    }

    @Override
    public void onTestFailure(ITestResult tr) {

	WebDriver webDriver = ((DriverSetup) tr.getInstance()).getDriver();

	System.out.println("Error. Capturing Screenshot...");
	saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
    }

}
