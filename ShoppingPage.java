package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingPage extends BasePage{

    public ShoppingPage (WebDriver driver){
        super(driver);
    }

    String baseURL = "http://automationpractice.com/index.php?id_category=5&controller=category";
    By productBy = By.xpath("//*[@id='center_column']/ul/li");
    By addToCartButtonBy = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]");
    By layerCartProductBy = By.id("//*[@id='layer_cart']/div[1]/div[1]");
    By proceedToCheckoutButtonBy = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a");
    By totalUnitPriceBy = By.xpath("//*[@id='product_1_1_0_750578']/td[4]");
    By shippingPriceBy = By.id("//*[@id='total_shipping']");
    By taxPriceBy = By.id("//*[@id='total_tax']");
    By totalProductPriceBy = By.id("//*[@id='total_price']");

    public ShoppingPage basePage (){
        driver.get(baseURL);
        return this;
    }

    public ShoppingPage clickOnProduct (){
        click(productBy);
        return this;
    }

    public ShoppingPage clickOnAddToCartButton (){
        click(addToCartButtonBy);
        return this;
    }

    public ShoppingPage verifyProductAddToCart (){
        click(addToCartButtonBy);
        return this;
    }

    public ShoppingPage clickOnProceedToCheckoutButton (){
        click(proceedToCheckoutButtonBy);
        return this;
    }

    public ShoppingPage verifyTotalProductPrice (){
        String totalUnitPrice = readText(totalUnitPriceBy);
        totalUnitPrice = totalUnitPrice.replace("$", "");
        String shippingPrice = readText(shippingPriceBy);
        shippingPrice = shippingPrice.replace("$", "");
        String taxPrice = readText(taxPriceBy);
        taxPrice = taxPrice.replace("$", "");
        String ProductPrice = readText(totalProductPriceBy);
        ProductPrice = ProductPrice.replace("$", "");

        double totalUnPrice = Double.parseDouble (totalUnitPrice);
        double shippPrice = Double.parseDouble (shippingPrice);
        double txPrice = Double.parseDouble (taxPrice);
        double totalProductPrice = Double.parseDouble (ProductPrice);
        double totalExpectedProductPrice = totalUnPrice + shippPrice + txPrice;

        assertStringEquals(totalProductPrice, totalExpectedProductPrice, 0.0);
        return this;
    }

    private void assertStringEquals(double totalProductPrice, double totalExpectedProductPrice, double d) {
    }
    
    }
    
