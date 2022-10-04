package Tests;

import org.junit.Test;

import Pages.HomePage;

public class HomePageTest extends BaseTest {
    public HomePage homePage;

    int numberOfPopularItems = 7;
    int numberOfBestsSellers = 7;

    @Test
    public void numberOfPopularItems (){
        homePage = new HomePage(driver);
        homePage.basePage();
        homePage.verifyNumberOfPopularItems (numberOfPopularItems);

        try {
            Thread.sleep(10000);
        }catch (InterruptedException error){
            error.printStackTrace();
        }
    }

    @Test
    public void numberOfBestsSellers (){
        homePage = new HomePage(driver);
        homePage.basePage();
        homePage.verifyBestSellersButton ();
        homePage.verifyNumberOfBestSellers (numberOfBestsSellers);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
        
    }
}