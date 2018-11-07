package com.tehnomanija.qa.basetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.model.Test;
import com.tehnomanija.qa.util.TestUtil;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Actions actions;
	
	public BaseTest() {
		
		try {
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream("D:\\AdicaSmarac\\TehnomanijaOnline\\src\\main\\java\\com\\tehnomanija\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = new String();
		browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\AdicaSmarac\\TehnomanijaOnline\\chromedriver.exe");
			driver = new ChromeDriver();
			actions = new Actions(driver);
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\AdicaSmarac\\TehnomanijaOnline\\geckodriver.exe");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	

}
