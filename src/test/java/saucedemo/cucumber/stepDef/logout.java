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

public class logout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";

    @Given("user on login page logout scenario")
    public void user_on_login_page_logout_scenario(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        WebElement acceptedUsernameH4 = driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/h4"));
        Assert.assertEquals(acceptedUsernameH4.getText(),"Accepted usernames are:");
    }

    @When("user input username logout scenario")
    public void user_input_username_logout_scenario(){
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
    }

    @And("user input password logout scenario")
    public void user_input_password_logout_scenario(){
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
    }

    @And("user click login button logout scenario")
    public void user_click_login_button_logout_scenario(){
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @And("user redirect to product page logout scenario")
    public void user_redirect_to_product_page_logout_scenario(){
        WebElement productSpan = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals(productSpan.getText(),"Products");
    }

    @And("user click sidebar menu logout scenario")
    public void user_click_sidebar_menu_logout_scenario(){
        WebElement sidebarMenuButton = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
        sidebarMenuButton.click();
    }

    @And("user click logout button logout scenario")
    public void user_click_logout_button_logout_scenario(){
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        logoutButton.click();
    }

    @Then("user redirect after logout to login page logout scenario")
    public void user_redirect_after_logout_to_login_page_logout_scenario(){
        WebElement acceptedUsernameH4Logout = driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/h4"));
        Assert.assertEquals(acceptedUsernameH4Logout.getText(),"Accepted usernames are:");
        driver.close();
    }
}
