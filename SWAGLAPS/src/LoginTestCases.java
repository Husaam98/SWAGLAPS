import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginTestCases {

	public AndroidDriver driver;
	public LoginTest loginPage;
	public SoftAssert softassert;

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		File app = new File("Android.SauceLabs.Mobile.Sample.app.2.7.1 (1).apk");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Qa's S20 FE");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.swaglabsmobileapp");
		caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");

		softassert = new SoftAssert();

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
		loginPage = new LoginTest(driver); // ✅ Initialize LoginPage
	}

	@Test(priority = 1)
	public void Enter_invalid_username_invalid_password() throws InterruptedException {
		LoginTest loginPage = new LoginTest(driver);

		loginPage.waitUserNameField();
		loginPage.userNameField.sendKeys("husam");

		loginPage.waitPasswordField();
		loginPage.passwordField.sendKeys("00000");

		loginPage.waitLoginButton();
		loginPage.loginButton.click();

		loginPage.waitErrorMessage();
		String actualResult = loginPage.errorMessage.getText();
		String expectedResult = "Username and password do not match any user in this service.";

		softassert.assertEquals(actualResult, expectedResult);

		loginPage.userNameField.clear();
		loginPage.passwordField.clear();
		softassert.assertAll();

	}

	@Test(priority = 2)
	public void Enter_valid_username_valid_password() throws InterruptedException {
		LoginTest loginPage = new LoginTest(driver);

		loginPage.waitUserNameField();
		loginPage.userNameField.sendKeys("standard_user");

		loginPage.waitPasswordField();
		loginPage.passwordField.sendKeys("secret_sauce");

		loginPage.waitLoginButton();
		loginPage.loginButton.click();

		loginPage.waitSideMenu();
		boolean actualResult = loginPage.sideMenu.isDisplayed();
		boolean expectedResult = true;

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

}
