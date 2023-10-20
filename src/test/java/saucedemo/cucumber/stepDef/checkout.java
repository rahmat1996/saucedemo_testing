package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";

    @Given("user already login and add product to cart and on cart page")
    public void user_already_login_and_add_product_to_cart_and_on_cart_page(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        WebElement acceptedUsernameH4 = driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/h4"));
        Assert.assertEquals(acceptedUsernameH4.getText(),"Accepted usernames are:");

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        WebElement productSpan = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals(productSpan.getText(),"Products");

        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        addToCartButton.click();

        WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        cartButton.click();

        WebElement productItemCart = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        Assert.assertEquals(productItemCart.getText(),"Sauce Labs Backpack");
    }

    @When("user click checkout button")
    public void user_click_checkout_button(){
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        WebElement checkoutInformationSpan = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals(checkoutInformationSpan.getText(),"Checkout: Your Information");
    }

    @And("user input first name")
    public void user_input_first_name(){
        WebElement firstNameInputCheckout = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        firstNameInputCheckout.sendKeys("Rahmat");
    }

    @And("user input last name")
    public void user_input_last_name(){
        WebElement lastNameInputCheckout = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        lastNameInputCheckout.sendKeys("Saja");
    }

    @And("user input postal code")
    public void user_input_postal_code(){
        WebElement postalCodeInputCheckout = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        postalCodeInputCheckout.sendKeys("12345");
    }

    @And("user click continue button")
    public void user_click_continue_button(){
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        continueButton.click();

        WebElement checkoutOverviewSpan = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals(checkoutOverviewSpan.getText(),"Checkout: Overview");
    }

    @And("user click finish button")
    public void user_click_finish_button(){
        WebElement finishButton = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
        finishButton.click();
    }

    @Then("user redirect to checkout complete page")
    public void user_redirect_to_checkout_complete_page(){
        WebElement completeTextH2 = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        Assert.assertEquals(completeTextH2.getText(),"Thank you for your order!");
        driver.close();
    }
}
