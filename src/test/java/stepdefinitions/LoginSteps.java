package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    private WebDriver driver;     

    @Given("I am in the login page")
    public void i_am_in_login_page(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @When("I enter standard_user in the username field")
    public void i_enter_term_in_username_field(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @When("I enter secret_sauce in the password field")
    public void i_enter_term_in_password_field(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("I click in Login button")
    public void click_login_button(){
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should see the products page")
    public void i_should_see_products_page(){
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("www.saucedemo.com/inventory.html"));
        String appLogo = driver.findElement(By.className("app_logo")).getText();
        assertTrue(appLogo.contains("Swag Labs"));
        String cart_link = driver.findElement(By.className("shopping_cart_link")).getText();
        assertNotNull(cart_link);
        String products = driver.findElement(By.className("title")).getText();
        assertEquals(products, "Products");

    }

    @And("I close the browser")
    public void i_close_browser(){
        driver.close();
    }
}
