package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


// find the search input field on google.com
        WebElement inputField = driver.findElement(By.name("q"));

        var longstring = "Happy 11 Street"; // not really long for the sake of this quick example

        String shortString = "Test2";
// this works but is slow
        //inputField.sendKeys(longstring);
        inputField.clear();
        Thread.sleep(3000);


//        JavascriptExecutor js = (JavascriptExecutor)driver;
//////        js.executeScript("document.getElementById('input').setAttribute('value', 'new 11 for element')");
//        js.executeScript("document.getElementById('APjFqb').value='value 11 here'");


        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.id("APjFqb"));
        action.moveToElement(element).sendKeys("Happy 11 Street").build().perform();


//        inputField = driver.findElement(By.id("APjFqb"));
//        js.executeScript("arguments[0].setAttribute('value', '" + shortString +"')", inputField);


        Thread.sleep(3000);
        driver.close();
        driver.quit();


// Output: TypeError: Object [object Object] has no method 'setAttributes'

//        inputField.setAttributes("value", longstring);

    }
}
