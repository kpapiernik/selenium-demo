import PageObjects.CategoryPage;
import PageObjects.ProductPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CartTest extends BaseTest{


    private final String categoryURL = "https://fakestore.testelka.pl/product-category/wspinaczka/";
    private final String productURL = "https://fakestore.testelka.pl/product/wspinaczka-island-peak/";


    @Test
    public void addProductToCartFromCategoryPage(){
        CategoryPage categoryPage = new CategoryPage(driver);
        boolean result = categoryPage.goTo(categoryURL).addToCart().viewCart().isProductInCart();
        Assertions.assertTrue(result, "The product has not been added to the cart. Remove button was not found for product id = 42. ");
    }

    @Test
    public void changeProductQuantity(){
        ProductPage productPage = new ProductPage(driver);
        String changedPrice = productPage.goTo(productURL).addToCart().goToCart().changeProductAmount(2).getPriceSum();
        Assertions.assertEquals("16 400,00 zł", changedPrice);
    }
}
