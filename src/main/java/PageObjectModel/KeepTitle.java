package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Integer.parseInt;

public class KeepTitle {
    public WebDriver driver;

    By str1 = By.xpath("//div[@id='mainFrame']/div[3]//span[@class='source_base_1NameSpan']");
    By str2 = By.xpath("//div[@id='mainFrame']/div[5]//span[@class='source_base_1NameSpan']");

    public KeepTitle(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText(String string){
        String titleText = driver.findElement(By.xpath("//div[@id='mainFrame']/div["+string+"]//span[@class='source_base_1NameSpan']")).getText();
        return titleText;
    }


    public WebElement getTitleStr1(){
        return driver.findElement(str1);
    }

    public WebElement getTitleStr2(){
        return driver.findElement(str2);
    }

}
