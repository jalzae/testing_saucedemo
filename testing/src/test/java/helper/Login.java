package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

  public void user_enter_right_username_and_password(WebDriver driver) {
    WebElement username = driver.findElement(By.id("user-name"));
    username.click();
    username.sendKeys("standard_user");

    WebElement password = driver.findElement(By.id("password"));
    password.click();
    password.sendKeys("secret_sauce");
  }

  public void click_login_button(WebDriver driver) {
    WebElement submit = driver.findElement(By.id("login-button"));
    submit.click();
  }

}
