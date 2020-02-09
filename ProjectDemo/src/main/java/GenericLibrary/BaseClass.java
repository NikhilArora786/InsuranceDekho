package GenericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ObjectRepository_PageObjectModel.LoginPage;

public class BaseClass {
	public WebDriver driver;
	
	@BeforeClass
	public void LaunchTheBrowser() throws IOException
	{
		File f=new File("C:\\Users\\hp\\Desktop\\InsuranceDekho\\ProjectDemo\\Data.properties");
		FileInputStream fin=new FileInputStream(f);
		Properties prop=new Properties();
		prop.load(fin);
		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromePath"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	@BeforeMethod
	public void loginIntoTheAplication() throws InterruptedException, IOException
	{
		LoginPage lpage=PageFactory.initElements(driver,LoginPage.class);
		lpage.enterUsername();
		Thread.sleep(4000);
		lpage.enterPassword();
		Thread.sleep(4000);
		lpage.clickOnLoginButton();
	}
	
	@AfterMethod
	public void logoutFromTheApplication()
	{
		
	}
	
	@AfterClass
	public void closeTheBrowser() throws InterruptedException
	{
		Thread.sleep(8000);
		driver.close();
	}
}
