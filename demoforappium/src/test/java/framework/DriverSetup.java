package framework;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * WebDriver setup class Implements methods to read settings from property file
 * and setup WebDriver instance based on them
 * 
 * @author y.pernerovskyy
 *
 */
public class DriverSetup {

    private Client client;
    private WebDriver driver;

    /**
     * Put here supported clients (clients) enumerator and implement necessary
     * branch in launchDriver() method
     */
    private enum Client {
	ANDROID, IOS
    }

    /**
     * Read settings from pom.xml and setup the Driver
     * 
     * @return configured WebDriver instance
     */
    public WebDriver setUp() {
	setClient(System.getProperty("targetClient"));
	return launchDriver();
    }

    /**
     * Setup the Driver with given URL and client
     * 
     * @param client
     * @return configured WebDriver instance
     */
    public WebDriver setUp(String client) {
	setClient(client);
	return launchDriver();
    }

    /**
     * Setup and run client
     * 
     * @return WebDriver instance
     */
    private WebDriver launchDriver() {

	switch (client) {
	case ANDROID:
	    System.out.println("Starting setup for Android");

	    DesiredCapabilities cap = new DesiredCapabilities();

	    cap = DesiredCapabilities.android();
	    cap.setCapability("deviceName", "Android Emulator");
	    cap.setCapability(CapabilityType.BROWSER_NAME, "");
	    cap.setCapability(CapabilityType.VERSION, "4.4");
	    cap.setCapability("platformName", "WIN");
	    cap.setCapability("app","D:\\src\\git\\EmotionsKeeper\\EmotionsKeeper\\bin\\MainActivity.apk");

	    try {
		driver = new AndroidDriver(new URL("http://localhost:5060/wd/hub"), cap);
	    } catch (Exception ex) {
		System.out
			.println("Error during starting Android appium driver: "
				+ ex.getMessage());
	    }

	    break;
	case IOS:

	    break;

	default:
	    driver = null;
	    break;
	}

	return driver;

    }

    /**
     * Set value of desired client based on input string
     * 
     * @param String
     *            clientName
     * 
     */
    private void setClient(String clientName) {

	try {
	    client = Client.valueOf(clientName.toUpperCase());
	} catch (Exception e) {
	    System.out
		    .println("Unknown client in config file. Android will be used as default.");
	    client = Client.ANDROID;
	}
    }

    /**
     * Close Client
     */
    public void shutDown() {
	driver.quit();
    }

    public WebDriver getDriver() {
	return driver;
    }

}