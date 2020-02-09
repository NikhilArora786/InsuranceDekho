package ObjectRepository_PageObjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
	File f=new File("C:\\Users\\hp\\Desktop\\InsuranceDekho\\ProjectDemo\\Data.properties");
	FileInputStream fin;
	Properties prop=new Properties();
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='LOGIN']")
	private WebElement loginButton;
	
	
	public void enterUsername() throws IOException
	{
		fin=new FileInputStream(f);
		prop.load(fin);
		username.sendKeys(prop.getProperty("username"));
	}
	
	public void enterPassword() throws IOException
	{
		fin=new FileInputStream(f);
		prop.load(fin);
		password.sendKeys(prop.getProperty("password"));
		
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	
	
}
