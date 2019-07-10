package mutiplebrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class MultiBrowser {
 
 public WebDriver driver;
 String URL="https://www.topdanmark.dk";
 
  @Parameters("browser")
 
  @BeforeClass
 
  // Passing Browser parameter from TestNG xml
 
  public void beforeTest(String browser) throws InterruptedException  {
 
  // If the browser is Firefox, then do this
  if(browser.equalsIgnoreCase("firefox")) {
	   System.setProperty("webdriver.gecko.driver","C:\\Users\\rahul.sonawane\\OWASP ZAP\\webdriver\\windows\\64\\geckodriver.exe");

   driver = new FirefoxDriver();
   
   //open topdenmark url
   
   driver.get(URL); 
  }
  
  // If browser is chrome, then do this	  
  else if (browser.equalsIgnoreCase("chrome")) { 
 
   // Here I am setting up the path for my chromedriver
 
   System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahul.sonawane\\git\\Travel 1\\Travel\\lib\\chromedriver.exe");
 
   driver = new ChromeDriver();
   
   //maximize the window
   driver.manage().window().maximize();
   
   //implicit wait
   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   
 //open topdenmark url
   driver.get(URL); 
   Thread.sleep(1000); 
   
 //open google
   driver.get("http://google.com");
   Thread.sleep(5000); 

 //finding the web element using name locator
   WebElement element1 = driver.findElement(By.name("q"));

   //Finding first search keyword "topdanmark"
   
   element1.sendKeys(new String[]{"topdanmark"});
   
   Thread.sleep(5000); 
 
  }
 
  
  }
 
  // Once Before method is completed, Test method will start
 
  @Test public void testScenarios() throws InterruptedException {
        

 } 
  
 
  @AfterClass public void afterTest() {
 
 driver.quit();
 
 }
 
}