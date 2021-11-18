package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{
    private WebDriverWait wait;

    private final By removeProductButton = By.cssSelector("a[data-product_id='42']");
    private final By productsInCartTable = By.cssSelector("table[class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']");
    private final By productAmountInput = By.cssSelector("input[id^='quantity']");
    private final By updateCartButton = By.cssSelector("button[name='update_cart']");
    private final By goToPaymentButton = By.cssSelector("a[class=\"checkout-button button alt wc-forward\"]");

    public CartPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    public boolean isProductInCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsInCartTable));
        return driver.findElement(removeProductButton).isDisplayed();
    }

    public CartPage changeProductAmount(int amount){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productAmountInput));
        WebElement amountInput = driver.findElement(productAmountInput);
        amountInput.clear();
        amountInput.sendKeys(Integer.toString(amount));
        wait.until(ExpectedConditions.elementToBeClickable(updateCartButton));
        driver.findElement(updateCartButton).click();
        return new CartPage(driver);
    }

    public String getPriceSum(){
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".blockUI"), 0));
        return driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div/table/tbody/tr[2]/td/strong/span/bdi"))
                .getText();
    }

    public OrderPage goToPayment(){
        wait.until(ExpectedConditions.elementToBeClickable(goToPaymentButton)).click();
        return new OrderPage(driver);
    }
}
