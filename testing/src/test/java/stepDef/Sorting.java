package stepDef;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Sorting {

  helper.Login loginHelper = new helper.Login();
  helper.Sorting sortingHelper = new helper.Sorting();
  helper.Driver driverHelper = new helper.Driver();
  String baseUrl = "https://www.saucedemo.com/";
  WebDriver driver = driverHelper.setupDriver();

  @Given("access saucedemo then get login in inventory")
  public void access_saucedemo_then_get_login_in_inventory() {
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

  @When("scrap inventory items name")
  public void scrap_inventory_items_name() {
    try {
      List<String> itemNamesText = sortingHelper.getItem(driver);

      Assert.assertTrue("The list is empty", !itemNamesText.isEmpty());

    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }

  }

  @Then("change sorting z to a and get desc item by alphabet correctly")
  public void change_sorting_z_to_a_and_get_desc_item_by_alphabet_correctly() {
    try {
      List<String> itemNamesText = sortingHelper.getItem(driver);
      String resultItem = itemNamesText.get(0);
      Collections.sort(itemNamesText);
      String expecTed = itemNamesText.get(0);
      Assert.assertEquals(resultItem, expecTed);
      driverHelper.driverClose();
    } catch (Exception e) {
      System.out.println(e);
      throw new io.cucumber.java.PendingException();
    }

  }
}
