package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{

    private final WebDriverWait wait;

    private final By addToCartButton = By.cssSelector("button[name='add-to-cart']");
    private final By goToCartButton = By.cssSelector("div[role='alert'] > a[class='button wc-forward']");

    public ProductPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public ProductPage goTo(String productURL){
        driver.navigate().to(productURL);
        return new ProductPage(driver);
    }

    public ProductPage addToCart(){
        driver.findElement(addToCartButton).click();
        return new ProductPage(driver);
    }

    public CartPage goToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(goToCartButton)).click();
        return new CartPage(driver);
    }
}
