package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
    By email = By.cssSelector("input#mail");
    By password = By.cssSelector("input#current-pass");
    By clickBtn = By.cssSelector("button#singInbut");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getClickBtn() {
        return driver.findElement(clickBtn);
    }
}
