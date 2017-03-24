package lab2;


import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.security.Password;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class lab2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
   
  CsvUtil data = new CsvUtil("C:\\Users\\lenovo\\Desktop\\3014218059_呼萌_lab2\\inputgit.csv");
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://121.193.130.195:8080";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
  }

  @Test
  public void testlab2() throws Exception {
	for(int i=1;i<data.getRowNum();i++){
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("name")).clear();
	    String num = data.getString(i, 0);
	    driver.findElement(By.id("name")).sendKeys(num);
	    driver.findElement(By.id("pwd")).clear();
	    String password  = num.substring(4);
	    driver.findElement(By.id("pwd")).sendKeys(password);
	    new Select(driver.findElement(By.id("gender"))).selectByVisibleText("女");
	    driver.findElement(By.id("submit")).click();
	    
	    String address = data.getString(i, 2);
	    
	    WebElement tbody = driver.findElement(By.id("table-main"));
	    String alignStr = tbody.getText();
	    List<WebElement> tds = tbody.findElements(By.tagName("td"));
	    assertEquals(address, tds.get(5).getText());
		
	}
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
