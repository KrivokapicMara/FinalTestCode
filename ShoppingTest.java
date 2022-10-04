package Tests;

import org.junit.Test;

import Pages.ShoppingPage;

public class ShoppingTest extends BaseTest {
    public ShoppingPage shoppingPage;

    @Test
    public void verifySuccesfulAddToCart (){
        shoppingPage = new ShoppingPage(driver);
        shoppingPage.basePage();
        shoppingPage.clickOnProduct();
        shoppingPage.clickOnAddToCartButton();
        shoppingPage.verifyProductAddToCart();
        shoppingPage.clickOnProceedToCheckoutButton();
        shoppingPage.verifyTotalProductPrice();
    }
}







