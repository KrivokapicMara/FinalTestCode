package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    
    public LoginPage (WebDriver driver){
        super (driver);
    }

    String baseUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    By headerSignInButtonBy = By.className("login");
    By createAnAccountButtonBy = By.id("SubmitCreate");
    By emailBy = By.id("email");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("SubmitLogin"); 
    By loginTitle = By.id("//*[@id='center_column']/p");
    By errorContainerBy = By.id("center_column"); 
    By wrongPasswordBy = By.className("//*[@id='center_column']/div[1]"); 
    By LogoutButtonBy = By.id("//*[@id='header']/div[2]/div/div/nav/div[2]/a"); 
    By pageHeadingBy = By.id("htmlcontent_top");


    public LoginPage loginPage(){
        driver.get(baseUrl);
        return this;
    }

    public LoginPage login (String email, String password){
        writeText(emailBy, email);
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }

    public LoginPage verifySuccessfulLogin (String expectedText){
        String acctualText = readText (loginTitle);
        assertStringEquals(expectedText, acctualText);
        return this;
    }

    public LoginPage verifyWrongPasswordLogin (String expectedTextError){
        String acctualText1 = readText (errorContainerBy);
        assertStringEquals(expectedTextError, acctualText1);
        return this;
    }

    public LoginPage verifyEmptyMailLogin (String expectedTextError){
        String acctualText2 = readText (errorContainerBy);
        assertStringEquals(expectedTextError, acctualText2);
        return this;
    }

    public LoginPage clickOnLogoutButton (){
        click(LogoutButtonBy);
        return this;
    }

    public LoginPage verifySuccessfulLogout (String expectedLogoutText){
        String acctualText = readText (pageHeadingBy);
        assertStringEquals (expectedLogoutText, acctualText);
        return this;
    }


    }
    


