package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;


import junit.framework.Assert;

public class TestBase {

	public static WebDriver dvr;
	public static Properties propConfig, propObjctRepo;
	public static Logger log;



	private static final String APPLICATION_NAME = "Caroobi Automation Data Sheet";

	/** Directory to store user credentials for this application. */
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"),
			".credentials/sheets.googleapis.com-java-quickstart");

	/** Global instance of the {@link FileDataStoreFactory}. */
	private static FileDataStoreFactory DATA_STORE_FACTORY;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	/** Global instance of the HTTP transport. */
	private static HttpTransport HTTP_TRANSPORT;

	@SuppressWarnings("deprecation")
	public void initBrowser(String browser) {


		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 

		System.out.println("==============================================" );
		System.out.println("Test started at :  "+ dtf.format(now));
		System.out.println("==============================================" );


		String OS = TestBase.OSDetector();

		if (browser.equalsIgnoreCase("chrome") && OS == "Linux") {

			System.out.println("OS Detected : Linux , Browser Launched : Chrome" );
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
			ChromeOptions options = new ChromeOptions();
			/*options.addArguments("start-maximized"); // open Browser in maximized mode
			options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			options.addArguments("--disable-gpu"); // applicable to windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems */
			//options.addArguments("--no-sandbox"); // Bypass OS security model
			options.addArguments("--headless");
			dvr = new ChromeDriver(options);
			dvr.manage().window().fullscreen();
			//dvr = new ChromeDriver();


		}

		else if (browser.equalsIgnoreCase("chrome") && OS == "Mac") {

			System.out.println("==============================================" );
			System.out.println("OS Detected : MAC , Browser Launched : Chrome" );
			System.out.println("==============================================" );

			System.setProperty("webdriver.chrome.driver", "./lib/chromedriver");

			Boolean headlesschrome = false;

			if (headlesschrome==true) {

				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--start-maximized");
				chromeOptions.addArguments("--window-size=1200,800");
				chromeOptions.addArguments("--disable-user-media-security=true");
				dvr = new ChromeDriver(chromeOptions);
				//dvr.manage().window().fullscreen();
				
			}else if (headlesschrome==false)

			{
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-user-media-security=true");
				dvr = new ChromeDriver(chromeOptions);
				dvr.manage().window().fullscreen();
			}

		}

		else if (browser.equalsIgnoreCase("firefox") && OS == "Windows") {

			System.out.println("OS Detected : Windows , Browser Launched : Firefox" );
			System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			capabilities.setCapability("marionette", true);
			dvr = new FirefoxDriver(capabilities);
		} else {
			throw new IllegalArgumentException("Error with launching browser driver.....");
		}

		// dvr.manage().window().maximize();
		dvr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public static String OSDetector() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return "Windows";
		} else if (os.contains("nux") || os.contains("nix")) {
			return "Linux";
		} else if (os.contains("mac")) {
			return "Mac";
		} else if (os.contains("sunos")) {
			return "Solaris";
		} else {
			return "Other";
		}

	}

	public void loadPropertiesFile() throws FileNotFoundException, IOException {

		propConfig = new Properties();
		propConfig.load(new FileInputStream("./object_repo/config.properties"));
		propObjctRepo = new Properties();
		propObjctRepo.load(new FileInputStream("./object_repo/objects.properties"));
	}


	/**
	 * @throws InterruptedException
	 */


	public int randomNumber() 
	{ 

		Random rand = new Random();
		int rand_int = rand.nextInt(100000);
		//System.out.println("Random Integers: "+rand_int);
		return rand_int;

	}

	public void openURL(String url) {
		
		
		dvr.get(url);
		System.out.println("Opening : " + url);

	}
	
	
	public void deleteCookies() {
		
		
		dvr.manage().deleteAllCookies();


	}
	
	
	
	public void quitInstance() {
		
		dvr.quit();
		System.out.println("Closed instance");

	}

	protected void addlogs(String Message) throws IOException {
		log.info(Message);

	}

	protected void addErrorlogs(Exception e, String errormsg) throws IOException {
		
		log.info(errormsg);

	}

	public void mouseHover(By by) {
		Actions act = new Actions(dvr);
		act.moveToElement(dvr.findElement(by)).build().perform();

	}

	public void explicit_wait(By by, long time) {
		WebDriverWait wd = new WebDriverWait(dvr, time);
		// wd.until(ExpectedElementConditions.isVisible())

		wd.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void explicit_wait_presence(By by, long time) {
		WebDriverWait wd = new WebDriverWait(dvr, time);
		// wd.until(ExpectedElementConditions.isVisible())

		wd.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void explicit_wait_click(By by, long time) {
		WebDriverWait wd = new WebDriverWait(dvr, time);

		wd.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void scrolltoTop() {
		((JavascriptExecutor) dvr).executeScript("window.scroll(0,0);");
	}

	public void handleAlert() {

		// System.out.println("Test inside alert");
		WebDriverWait wait = new WebDriverWait(dvr, 5);

		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Test inside alert");
		Alert alert = dvr.switchTo().alert();
		alert.accept();

	}

	public void type(By element, String value) {

		Assert.assertTrue(dvr.findElements(element).size()>0);
		dvr.findElement(element).sendKeys(value);


	}


	public void enter(By element) {

		dvr.findElement(element).sendKeys(Keys.ENTER);
		

	}


	public void clickjs(By element) {

		((JavascriptExecutor) dvr).executeScript("arguments[0].click();", element);

	}




	public void typejs(By element, String value) {

		((JavascriptExecutor) dvr).executeScript("arguments[0].value='" + value + "';", dvr.findElement(element));

	}

	public void clear(By element) {

		dvr.findElement(element).clear();
		Assert.assertTrue(dvr.findElements(element).size()>0);

	}



	public String getCurrentUrl() {

		String currenturl= dvr.getCurrentUrl();
		return currenturl;

	}

	public void refreshpage() {

		dvr.navigate().refresh();

	}




	public String getText(By element) {

		String text=(new WebDriverWait(dvr, 20).until(ExpectedConditions.visibilityOfElementLocated(element)).getAttribute("innerHTML"));

		return text;


	}



	private boolean Assert(String string, boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

	public void click(By element) {

		Assert.assertTrue(dvr.findElements(element).size()>0);
		dvr.findElement(element).click();

	}

	public void selectValueDropdown(By element, String text) {

		Select sel = new Select(dvr.findElement(element));
		sel.selectByVisibleText(text);

	}

	public void verifyElement(By element) throws Exception {
		try {
			Assert.assertTrue(dvr.findElement(element).isDisplayed());
			addlogs("Element " + element + " found on page");
			System.out.println("Element " + element + " found on page");
		} catch (AssertionError e) {
			System.out.println("Element " + element + " not found on page");
			throw new Exception("element " + element + " not found on page");
		} catch (Exception e) {
			System.out.println("Element " + element + " not found on page");
			throw new Exception("element " + element + " not found on page");
		}

	}

	public boolean isElementDisplayed(By element) throws Exception {
		try {
			Assert.assertTrue(dvr.findElement(element).isDisplayed());
			addlogs("Element " + element + " found on page");
			System.out.println("Element " + element + " found on page");
			return true;
		} catch (AssertionError e) {
			System.out.println("Element " + element + " not found on page");
			return false;
		} catch (Exception e) {
			System.out.println("Element " + element + " not found on page");
			return false;
		}

	}

	public void verifyElementPresence(By element) throws Exception {
		try {
			Assert.assertTrue(dvr.findElement(element).isEnabled());
			addlogs("Element " + element + " found on page");
			System.out.println("Element " + element + " found on page");
		} catch (AssertionError e) {
			System.out.println("Element " + element + " not found on page");
			throw new Exception("element " + element + " not found on page");
		} catch (Exception e) {
			System.out.println("Element " + element + " not found on page");
			throw new Exception("element " + element + " not found on page");
		}

	}

	public String getAttribute(By element, String attribute) {
		try {
			String attributeval = dvr.findElement(element).getAttribute(attribute);
			return attributeval;
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			return null;
		}
	}

	protected void scrolltoElement(By element) {
		((JavascriptExecutor) dvr).executeScript("arguments[0].scrollIntoView();", dvr.findElement(element));
	}

	protected List<WebElement> getMultipleWebElement(By element) {
		List<WebElement> elements = dvr.findElements(element);
		return elements;
	}
	
	
	
	
	protected void escape() {
	Actions action = new Actions(dvr);
	action.sendKeys(Keys.ESCAPE).perform();
	
	}
	
	
	


}
