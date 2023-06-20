import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://eturkistan.com/#/sign-in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("input#mail")).sendKeys("ab.nurum@gmail.com");
        driver.findElement(By.cssSelector("input#current-pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#singInbut")).click();

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("div#container > div:nth-of-type(2)")).click();
        Thread.sleep(5000);

        WebElement element1 = driver.findElement(By.xpath("//div[@id='mainFrame']/div[1]//span[@class='source_base_1NameSpan']"));
        System.out.println(element1.getText());


        WebElement element2 = driver.findElement(By.xpath("//div[@id='mainFrame']/div[2]//span[@class='source_base_1NameSpan']"));
        System.out.println(element2.getText());

    }

}
