import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.time.Duration;
import java.util.List;

public class LoginTest {

    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[class = 'initialComponent-hk7c_9tvgJ8ELzRuGJwC']")).click(); //search button clicked
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[class = 'searchBarContent-UfviL0lUukyp5yKZTi4k']")).sendKeys("laptop"); //a laptop is typed
        Thread.sleep(3000);
        driver.findElements(By.cssSelector("[class = 'suggestion-lhRLulu_2T1ZBMfVLv1X']")).get(1).click(); //word choice
        Thread.sleep(3000);
       // driver.findElements(By.cssSelector("[class = 'moria-ProductCard-jmtwOA expP swnvhjgo9zm']")).get(0).click(); //image choice

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)"); //500px scroll down

        List<WebElement> products = driver.findElements(By.cssSelector("[class = 'productListContent-zAP0Y5msy8OHn5z7T_K_']")); //all products selected

        if (products.size() > 0) {  //first product clicked
            products.get(0).click();
        }
        Thread.sleep(3000);

        WebElement addToCartButton = driver.findElement(By.cssSelector("[class='VZMbm89fzHuumKKSNdPb QQT2ceznooRrb4cvyd05']")); // find item
        js.executeScript("arguments[0].scrollIntoView();", addToCartButton); //Use scrollIntoView() to make the element visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //Wait for the item to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        addToCartButton.click(); // click on cart

        Assert.assertEquals(driver.findElement(By.cssSelector("[class = 'checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']")), " Ürün sepetinizde");

        driver.findElement(By.cssSelector("[class = 'checkoutui-Modal-iHhyy79iR28NvF33vKJb']")).click();

        driver.findElement(By.id("shoppingCart")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("continue_step_btn")).click();
        Thread.sleep(3000);


        //driver.quit();
    }

}