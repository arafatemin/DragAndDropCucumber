import Base.BaseClass;
import PageObjectModel.HomePage;
import PageObjectModel.KeepTitle;
import PageObjectModel.LoginPage;
import gherkin.lexer.Th;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DragAndDropStepDefinitions extends BaseClass {


    public DragAndDropStepDefinitions() throws IOException {
        super();
    }

    @Given("I launch SDBO")
    public void i_launch_sdbo() {
        driver = getDriver(); // chrome
        driver.get(getUrl()); // eturkistan.com
    }

    @When("I login with usename {string} and password {string}")
    public void i_login_with_usename_and_password(String string, String string2) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys(string);
        loginPage.getPassword().sendKeys(string2);
        loginPage.getClickBtn().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("I click on SDBO Resource section")
    public void i_click_on_sdbo_resource_section() {
        HomePage homePage = new HomePage(driver);
        homePage.getSecondBtn().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("I save {string} title name")
    public void i_save_title_name(String string) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        KeepTitle keepTitle = new KeepTitle(driver);
        String string0 = keepTitle.getTitleText(string);
        Thread.sleep(3000);
    }


    @When("I drag item {string} to item {string}")
    public void i_drag_item_to_item(String string, String string2) throws InterruptedException {
        WebElement dragAbleElement = driver.findElement(By.xpath("//div[@id='mainFrame']/div["+string+"]//span[@class='source_base_1NameSpan']"));
        WebElement dropAbleElement = driver.findElement(By.xpath("//div[@id='mainFrame']/div["+string2+"]//span[@class='source_base_1NameSpan']"));
        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        Action dragAndDrop = actions.clickAndHold(dragAbleElement)
                .moveToElement(dropAbleElement)
                .release(dropAbleElement)
                .build();
        dragAndDrop.perform();

    }

    @Then("I verify {string} title same as saved title name")
    public void i_verify_title_same_as_saved_title_name(String string) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        KeepTitle keepTitle = new KeepTitle(driver);
        int a = Integer.parseInt(string);
        String getString = keepTitle.getTitleText(string);
        if (a<4){
            Assert.assertEquals(getString, keepTitle.getTitleStr1().getText(), "Test Failed");
        }
        else {
            Assert.assertEquals(getString, keepTitle.getTitleStr2().getText(), "Test Failed");
        }

    }
}
