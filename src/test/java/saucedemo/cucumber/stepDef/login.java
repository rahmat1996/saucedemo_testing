package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";

    @Given("user on login page")
    public void user_on_login_page(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        WebElement acceptedUsernameH4 = driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/h4"));
        Assert.assertEquals(acceptedUsernameH4.getText(),"Accepted usernames are:");
    }

    @When("user input username")
    public void user_input_username(){
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
    }

    @And("user input password")
    public void user_input_password(){
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
    }

    @And("user input invalid password")
    public void user_input_invalid_password(){
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("12345");
    }

    @And("user click login button")
    public void user_click_login_button(){
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("user redirect to product page")
    public void user_redirect_to_product_page(){
        WebElement productSpan = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals(productSpan.getText(),"Products");
        driver.close();
    }

    @Then("user get error message")
    public void user_get_error_message(){
        WebElement errorH3 = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertEquals(errorH3.getText(),"Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
