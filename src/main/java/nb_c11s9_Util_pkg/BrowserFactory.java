
// Selenium Class 11.a:- July 16, 2023, Sunday with Instructor Shihabul Khandakar (Shibab) 


package nb_c11s9_Util_pkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserFactory {

	
	// Software Development Technology:
			// TDD :
				// Data Driven Testing Framework: 
			// BDD : 
				// Behavior Driven Development Framework
		
		// Gherkin: is a set of grammar rules that makes plain text structured enough for Cucumber to understand. 
			// The scenario above is written in Gherkin. Gherkin serves multiple purposes: Unambiguous executable specification. Automated testing using Cucumber.
		
		// Types of Test Automation Framework"
			// 
		  
	
	// Types of Testing:
		// 1. Unit Testing: I never had to do this particular one because our DevOps used to perform this.
		// 2. QA: smoke, sanity, regression, functional, white box, black box, gray box, ad hoc, gorilla, end to end, integration, non-functional
	
		
		// 3. Others: Stress, Load, Escability, Security, performance,
			// we need tools like Jmeter, LoadRunner, etc. 
	
	// Every application has 3 phases: front, middle tier, and back end:
		// 1. Functional Testing: Functional testing is a type of testing that seeks to establish whether each application feature works as per the software requirements. 
					// Each function is compared to the corresponding requirement to ascertain whether its output is consistent with the end user's expectations.
		// 2. Regression:  is done to check only the functional testing at the front end ...
		// 3. End to End: if your team is running from front to end then, it is called end to end... End-to-end testing (E2E testing) is a testing method that evaluates the entire application flow, from start to finish. 
			// It ensures that all components work as expected and the software application functions correctly in real-world scenarios.
			// checks top to bottom and the deep inside functionalities as well
	
	
	// Smoke testing is performed to ascertain that the acute functionalities of the program are operating properly. 
			// before deployment, you want to check if all the major functionalities are working fine or not
	// Sanity testing is done to check that bugs have been fixed after the build. This is done before running deep into the application. 
		// Smoke testing can be documented and scripted. while Sanity testing can't be documented and is unscripted.
		// sanity is when you dig deep into the functionalities, and checks whether certain bugs have been fixed or new stuff has been working properly or not
	
	
	// if we are dealing with excel, we can use TestNG to manage our test cases
	
	
	// IQA 1: What kind of project have you worked on?
		// I have worked on data-driven project where:
			// 1. the language I have used is Java. 
			// 2. Project management tool is Maven
			// 3. For automating front end test cases: Selenium
			// 4. For Framework management tool : JUnit and TestNG
			// 5. For data management: either XML, Excel 
					// How do you read excel file?
						// --> we need the dependency of apache POI and apache poi -ooxml. 
						// Also if I am using version 2009 or later/newer, I will be using XSSF filing system
						// if I am using the version 2007 or older, then I will be using use HSSF filing system
					// How do you import data with XML?
						// --> TestNG has introduced a bunch of annotations, and among them @Parameters is what I would like to utilize 
					
					
			// 6. For Reporting: TestNG reporting system or Extent Report for JUnit
			// 7. I have also applied POM, which is an object design pattern, to my project for its several benefits. It helps to keep my project very organized and smoothly running our cases
					// Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements. 
						// It helps reduce code duplication and improves test case maintenance. 
						// In Page Object Model, consider each web page of an application as a class file.
	
	
	// Role of SDET:
		// Running the manual testing, automation and DevOps (building the pipeline for Jenkins -pull the codes, merge, and send emails about the modifications)
	
	
	// shortcuts: 
		// 1. to comment in XML: cmd + shift + c....it does  <!--    -->
		// 2. to comment in eclipse: cmd + frontSlash(/).....it does //
		// 3. to comment whole blocks in eclipse: cmd + ctrl + /  .... it does /*...*/
			// 4. to uncomment: cmd + ctrl + backSlash(\)   ...... 
		// 5. to comment in mySQL: it does -- or cmd + frontSlash(/)

	
	// ================================================================================================

	
	static WebDriver driver;
	static String browser;
	static String url;

	public static void readConfig() {
		try {
			InputStream input = new FileInputStream("src/main/java/config/config.properties");
			Properties prop = new Properties();
			prop.load(input);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");

		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver init() {   // changing the method into WebDriver return type

		readConfig();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
			driver = new FirefoxDriver();
		} 
		else {
			System.out.println("Please launch again using the appropriate browser!!!");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void tearDown() throws InterruptedException {
		Thread.sleep(1500);
		driver.close();
		driver.quit();

	}
}
	
