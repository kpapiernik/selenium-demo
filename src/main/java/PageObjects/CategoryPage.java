package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage extends BasePage {

    private WebDriverWait wait;

    private By addToCartButton = By.cssSelector("a[data-product_id='42']");
    private By goToCartButton = By.cssSelector(".added_to_cart");

    public CategoryPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public CategoryPage goTo(String categoryURL){
        driver.navigate().to(categoryURL);
        return new CategoryPage(driver);
    }

    public CategoryPage addToCart(){
        driver.findElement(addToCartButton).click();
        return new CategoryPage(driver);
    }

    public CartPage viewCart(){
        wait.until(ExpectedConditions.elementToBeClickable(goToCartButton)).click();
        return new CartPage(driver);
    }
}
