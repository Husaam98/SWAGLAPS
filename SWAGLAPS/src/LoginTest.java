import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class LoginTest {

	private AndroidDriver driver;
	private WebDriverWait wait;

	public LoginTest(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this); // ✅ Initialize elements correctly
	}

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
	public WebElement userNameField;

	public WebElement waitUserNameField() {
		userNameField = wait.until(ExpectedConditions.visibilityOf(userNameField));
		return userNameField;
	}

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
	public WebElement passwordField;

	public WebElement waitPasswordField() {
		passwordField = wait.until(ExpectedConditions.visibilityOf(passwordField));
		return passwordField;
	}

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
	public WebElement loginButton;

	public WebElement waitLoginButton() {
		loginButton = wait.until(ExpectedConditions.visibilityOf(loginButton));
		return loginButton;
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]")
	public WebElement errorMessage;

	public WebElement waitErrorMessage() {
		errorMessage = wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage;

	}

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
	public WebElement sideMenu;

	public WebElement waitSideMenu() {
		sideMenu = wait.until(ExpectedConditions.visibilityOf(sideMenu));
		return sideMenu;
	}

}
