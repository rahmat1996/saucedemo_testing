package saucedemo.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart {
    @Test
    public void test_add_cart_success(){
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

        driver.close();
    }
}
