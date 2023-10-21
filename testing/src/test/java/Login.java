
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
  @Test
  public void open_driver() {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    WebDriverManager.chromedriver().setup();

    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(baseUrl);

    String title = driver.getTitle();
    System.out.println(title);

    WebElement username = driver.findElement(By.id("user-name"));
    username.click();
    username.sendKeys("standard_user");

    WebElement password = driver.findElement(By.id("password"));
    password.click();
    password.sendKeys("secret_sauce");

    WebElement submit = driver.findElement(By.id("login-button"));
    submit.click();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    String expectedURL = baseUrl + "inventory.html";

    driver.getCurrentUrl().equals(expectedURL);
    String currentURL = driver.getCurrentUrl();
    Assert.assertEquals(currentURL, expectedURL);

    driver.close();
  }
}
