package saucedemo.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logout {
    @Test
    public void test_logout_success(){
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

        WebElement sidebarMenuButton = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
        sidebarMenuButton.click();

        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        logoutButton.click();

        WebElement acceptedUsernameH4Logout = driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/h4"));
        Assert.assertEquals(acceptedUsernameH4Logout.getText(),"Accepted usernames are:");

        driver.close();
    }
}
