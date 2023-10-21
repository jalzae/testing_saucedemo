package stepDef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
  WebDriver driver;
  String baseUrl = "https://www.saucedemo.com/";

  @Given("access saucedemo")
  public void access_saucedemo() {
    // Write code here that turns the phrase above into concrete actions
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(baseUrl);
    String title = driver.getTitle();
    System.out.println(title);
    Assert.assertEquals(title, "Swag Labs");
  }

  @When("user not enter the form and have blank form")
  public void user_not_enter_the_form_and_have_blank_form() {
    // Write code here that turns the phrase above into concrete actions
    WebElement username = driver.findElement(By.id("user-name"));
    username.click();
    username.sendKeys("");

    WebElement password = driver.findElement(By.id("password"));
    password.click();
    password.sendKeys("");

    Assert.assertEquals(username.getAttribute("value"), "");
    Assert.assertEquals(password.getAttribute("value"), "");
  }

  @When("User have no right validation and enter the form")
  public void User_have_no_right_validation_and_enter_the_form() {
    // Write code here that turns the phrase above into concrete actions
    WebElement username = driver.findElement(By.id("user-name"));
    username.click();
    username.sendKeys("secret_sauce");

    WebElement password = driver.findElement(By.id("password"));
    password.click();
    password.sendKeys("secret_sauce");

    Assert.assertEquals(username.getAttribute("value"), "secret_sauce");
    Assert.assertEquals(password.getAttribute("value"), "secret_sauce");
  }

  @When("click login button")
  public void click_login_button() {
    WebElement submit = driver.findElement(By.id("login-button"));
    Assert.assertTrue("Login button is  displayed.", submit.isDisplayed());
    submit.click();
  }

  @Then("will be show error message to require the form")
  public void will_be_show_error_message_to_require_the_form() {
    WebElement errorMessage = driver.findElement(By.xpath("//h3[contains(text(), 'Username is required')]"));
    Assert.assertTrue("Error message is displayed.", errorMessage.isDisplayed());
    driver.close();
  }

  @Then("Will be error message validation")
  public void Will_be_error_message_validation() {
    WebElement errorMessage = driver
        .findElement(By.xpath("//h3[contains(text(), 'Username and password do not match')]"));
    Assert.assertTrue("Error message is displayed.", errorMessage.isDisplayed());
    driver.close();
  }

  @When("user enter right username and password")
  public void user_enter_right_username_and_password() {
    WebElement username = driver.findElement(By.id("user-name"));
    username.click();
    username.sendKeys("standard_user");

    WebElement password = driver.findElement(By.id("password"));
    password.click();
    password.sendKeys("secret_sauce");

    Assert.assertEquals(username.getAttribute("value"), "standard_user");
    Assert.assertEquals(password.getAttribute("value"), "secret_sauce");
  }

  @Then("home page will be displayed")
  public void home_page_will_be_displayed() {
    String expectedURL = baseUrl + "inventory.html";

    driver.getCurrentUrl().equals(expectedURL);
    String currentURL = driver.getCurrentUrl();
    Assert.assertEquals(currentURL, expectedURL);
    driver.close();
  }

}
