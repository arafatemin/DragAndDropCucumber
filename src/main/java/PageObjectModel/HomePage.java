package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver;
    By secondBtn = By.cssSelector("div#container > div:nth-of-type(2)");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSecondBtn(){
        return driver.findElement(secondBtn);
    }
}
