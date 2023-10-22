package stepDef;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCart {
  helper.Login loginHelper = new helper.Login();
  helper.Sorting sortingHelper = new helper.Sorting();
  helper.Driver driverHelper = new helper.Driver();
  String baseUrl = "https://www.saucedemo.com/";
  WebDriver driver = driverHelper.setupDriver();

  @Given("access saucedemo then get login to inventorys")
  public void access_saucedemo_then_get_login_to_inventorys() {
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

  @When("scrap all inventory item names")
  public void scrap_all_inventory_item_names() {
    try {
      List<String> itemNamesText = sortingHelper.getItem(driver);

      Assert.assertTrue("The list is empty", !itemNamesText.isEmpty());
    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @Then("add to product on carts")
  public void add_to_product_on_carts() {
    WebElement firstInventoryItem = driver.findElement(By.className("inventory_item"));
    WebElement firstAddToCartButton = firstInventoryItem.findElement(By.className("btn_inventory"));
    firstAddToCartButton.click();

    WebElement items = driver.findElement(By.id("remove-sauce-labs-backpack"));
    String buttonText = items.getText();
    Assert.assertEquals(buttonText, "Remove");
    try {

    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @Then("check the number on cart detail")
  public void check_the_number_on_cart_detail() {
    try {
      // Write code here that turns the phrase above into concrete actions
      // check number of cart
      WebElement shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"));
      String badgeText = shoppingCartBadge.getText();
      Assert.assertEquals(badgeText, "1");
    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }

  @Then("access cart page and get item counts")
  public void access_cart_page_and_get_item_counts() {
    try {
      // Write code here that turns the phrase above into concrete actions
      // go to page cart
      // get list items
      // Navigate to the "cart.html" page
      driver.get(baseUrl + "cart.html");
      List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
      int itemCount = cartItems.size();
      System.out.println("Number of cart items: " + itemCount);
      Assert.assertEquals(itemCount, 1);
      driverHelper.driverClose();
    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }
  }
}
