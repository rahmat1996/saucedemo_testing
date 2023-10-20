package saucedemo.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkout {
    @Test
    public void test_checkout_success(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com";

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

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        WebElement checkoutInformationSpan = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals(checkoutInformationSpan.getText(),"Checkout: Your Information");

        WebElement firstNameInputCheckout = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        firstNameInputCheckout.sendKeys("Rahmat");

        WebElement lastNameInputCheckout = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        lastNameInputCheckout.sendKeys("Saja");

        WebElement postalCodeInputCheckout = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        postalCodeInputCheckout.sendKeys("12345");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        continueButton.click();

        WebElement checkoutOverviewSpan = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals(checkoutOverviewSpan.getText(),"Checkout: Overview");

        WebElement finishButton = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
        finishButton.click();

        WebElement completeTextH2 = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        Assert.assertEquals(completeTextH2.getText(),"Thank you for your order!");

        driver.close();
    }
}
