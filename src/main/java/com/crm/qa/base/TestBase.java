package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public  static WebDriver driver;
	 public static Properties prop;
	
	public TestBase(){
		try {
			FileInputStream fi = new FileInputStream("C:\\Users\\Mann Josan\\OneDrive\\Desktop\\Selenium\\Selenium_WorkSpace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\config\\confif.properties");
			 prop = new Properties();
			prop.load(fi);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

    public static void initialization() {
    	String browserName = prop.getProperty("browser");
    	if (browserName.equals("firefox")) {
    			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mann Josan\\Desktop\\Selenium\\SeleniumJars\\geckodriver.exe");
    			  driver = new FirefoxDriver();
    		}
    		else if (browserName.equals("Chrome")) {
               System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mann Josan\\Desktop\\Selenium\\SeleniumJars\\chromedriver.exe");
    		    driver= new ChromeDriver();
    		}
    		else {
    			System.setProperty("webdriver.safari.driver", "C:\\Users\\Mann Josan\\Desktop\\Selenium\\SeleniumJars\\safaridriver.exe");
    			  driver = new SafariDriver();
    			
    		}
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));
    	}
	
}


