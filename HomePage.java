package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    String baseUrl = "http://automationpractice.com/index.php";
    By numberOfPopularItems = By.xpath("//*[@id='homefeatured']"); 
    By popularButton = By.xpath("//*[@id='home-page-tabs']/li[1]/a");
    By numberOfBestsSellers = By.xpath("//*[@id='blockbestsellers']/li[1]");
    By bestSellersButton = By.xpath("//*[@id='home-page-tabs']/li[2]/a");

    public HomePage basePage (){
        driver.get(baseUrl);
        return this;
    }

    public HomePage verifyPopularButton (){
        click(popularButton);
        return this;
    }

    public HomePage verifyNumberOfPopularItems (int expectedNumberOfPopularItems){
        int actualNumberOfPopularItems = countItems (numberOfPopularItems);
        assertIntigerEquals(expectedNumberOfPopularItems, actualNumberOfPopularItems);
        return this;
    }
    
    public HomePage verifyBestSellersButton (){
        click(bestSellersButton);
        return this;
    }

      public HomePage verifyNumberOfBestSellers (int expectedNumberOfBestSellers){
        int actualNumberOfBestSellers = countItems (numberOfBestsSellers);
        assertIntigerEquals(expectedNumberOfBestSellers, actualNumberOfBestSellers);
        return this;
    }



}
    

