import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import java.io.ByteArrayOutputStream;

public class LoginTest {

    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[class = 'initialComponent-hk7c_9tvgJ8ELzRuGJwC']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[class = 'searchBarContent-UfviL0lUukyp5yKZTi4k']")).sendKeys("t-shirt");
        Thread.sleep(3000);

        driver.findElements(By.cssSelector("[class = 'suggestion-lhRLulu_2T1ZBMfVLv1X']")).get(0).click();

        Thread.sleep(3000);

        driver.findElements(By.cssSelector("[class = 'moria-ProductCard-exfLof eMjQ so6v7ay124z']")).get(0).click();

        //driver.quit();
    }

}