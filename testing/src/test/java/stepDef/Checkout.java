package stepDef;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkout {
  helper.Login loginHelper = new helper.Login();
  helper.Sorting sortingHelper = new helper.Sorting();
  helper.Driver driverHelper = new helper.Driver();
  String baseUrl = "https://www.saucedemo.com/";
  WebDriver driver = driverHelper.setupDriver();

  @Given("access saucedemo then get login to inventory")
  public void access_saucedemo_then_get_login_to_inventory() {
    // Write code here that turns the phrase above into concrete actions
    try {
      driver.get(baseUrl);

      loginHelper.user_enter_right_username_and_password(driver);
      loginHelper.click_login_button(driver);

      String expectedURL = baseUrl + "inventory.html";

      driver.getCurrentUrl().equals(expectedURL);
      String currentURL = driver.getCurrentUrl();
      Assert.assertEquals(currentURL, expectedURL);
    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @When("scrap all inventory item name")
  public void scrap_all_inventory_item_name() {
    // Write code here that turns the phrase above into concrete actions
    List<String> itemNamesText = sortingHelper.getItem(driver);

    Assert.assertTrue("The list is empty", !itemNamesText.isEmpty());
    try {

    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @Then("add to product on cart")
  public void add_to_product_on_cart() {
    // Write code here that turns the phrase above into concrete actions
    try {
      WebElement firstInventoryItem = driver.findElement(By.className("inventory_item"));
      WebElement firstAddToCartButton = firstInventoryItem.findElement(By.className("btn_inventory"));
      firstAddToCartButton.click();

      WebElement items = driver.findElement(By.id("remove-sauce-labs-backpack"));
      String buttonText = items.getText();
      Assert.assertEquals(buttonText, "Remove");
    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @Then("check the number on cart details")
  public void check_the_number_on_cart_details() {
    // Write code here that turns the phrase above into concrete actions
    try {
      WebElement shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"));
      String badgeText = shoppingCartBadge.getText();
      Assert.assertEquals(badgeText, "1");

    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @Then("access cart page and get item count")
  public void access_cart_page_and_get_item_count() {
    // Write code here that turns the phrase above into concrete actions
    try {
      driver.get(baseUrl + "cart.html");
      List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
      int itemCount = cartItems.size();
      System.out.println("Number of cart items: " + itemCount);
      Assert.assertEquals(itemCount, 1);
    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @Then("click checkout button")
  public void click_checkout_button() {
    // Write code here that turns the phrase above into concrete actions
    try {

      WebElement checkoutButton = driver.findElement(By.id("checkout"));
      checkoutButton.click();
      String expectedURL = baseUrl + "checkout-step-one.html";

      driver.getCurrentUrl().equals(expectedURL);
      String currentURL = driver.getCurrentUrl();
      Assert.assertEquals(currentURL, expectedURL);

    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @Then("fill the form uncorrectly")
  public void fill_the_form_uncorrectly() {
    // Write code here that turns the phrase above into concrete actions
    try {
      WebElement firstName = driver.findElement(By.id("first-name"));
      firstName.click();
      firstName.sendKeys("a");
      WebElement lastName = driver.findElement(By.id("last-name"));
      lastName.click();
      lastName.sendKeys("b");

    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @Then("fill the form correctly")
  public void fill_the_form_correctly() {
    // Write code here that turns the phrase above into concrete actions
    try {
      WebElement firstName = driver.findElement(By.id("first-name"));
      firstName.click();
      firstName.sendKeys("a");
      WebElement lastName = driver.findElement(By.id("last-name"));
      lastName.click();
      lastName.sendKeys("b");
      WebElement postalCode = driver.findElement(By.id("postal-code"));
      postalCode.click();
      postalCode.sendKeys("51235");
    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @Then("show error require")
  public void show_error_require() {
    // Write code here that turns the phrase above into concrete actions
    try {
      WebElement checkoutButton = driver.findElement(By.id("continue"));
      checkoutButton.click();
      By errorMessageLocator = By.xpath("//h3[contains(@data-test, 'error')]");
      WebElement errorMessage = driver.findElement(errorMessageLocator);
      assertTrue("Error message is not present.", errorMessage != null);
      driverHelper.driverClose();
    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @Then("go to checkout step two pages")
  public void go_to_checkout_step_two_pages() {
    // Write code here that turns the phrase above into concrete actions
    try {
      WebElement checkoutButton = driver.findElement(By.id("continue"));
      checkoutButton.click();
      String expectedURL = baseUrl + "checkout-step-two.html";

      driver.getCurrentUrl().equals(expectedURL);
      String currentURL = driver.getCurrentUrl();
      Assert.assertEquals(currentURL, expectedURL);
    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @Then("go to checkout complete")
  public void go_to_checkout_complete() {
    // Write code here that turns the phrase above into concrete actions
    try {
      // finish
      WebElement checkoutButton = driver.findElement(By.id("finish"));
      checkoutButton.click();
      String expectedURL = baseUrl + "checkout-complete.html";

      driver.getCurrentUrl().equals(expectedURL);
      String currentURL = driver.getCurrentUrl();
      Assert.assertEquals(currentURL, expectedURL);
      driverHelper.driverClose();
    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }
}
