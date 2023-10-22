package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
  WebDriver driver;

  public void driverClose() {
    driver.close();
  }

  public WebDriver setupDriver() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    return driver;
  }
}
