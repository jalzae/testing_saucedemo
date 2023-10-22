package helper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sorting {

  public List<String> getItem(WebDriver driver) {
    List<WebElement> itemNames = driver.findElements(By.className("inventory_item_name"));
    List<String> itemNamesText = new ArrayList<String>();
    for (WebElement itemName : itemNames) {
      itemNamesText.add(itemName.getText());
    }
    return itemNamesText;
  }
}
