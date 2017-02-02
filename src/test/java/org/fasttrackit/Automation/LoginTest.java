package org.fasttrackit.Automation;


import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.automation.LoginPage;
import org.fasttrackit.automation.LoginView;
import org.fasttrackit.util.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginTest extends TestBase {

  //  private LoginPage page;
    private LoginView page = new LoginView();

    public LoginTest() {

      //  page = PageFactory.initElements(driver,LoginPage.class);

    }

    @Test
    public void validLoginTest() {

        openBrowser();

        login("eu@fast.com", "eu.pass");

        try {

            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException er) {
            Assert.fail("Could not login. Logout button was not pressent!");

        }

    }



    @Test
    public void invalidPasswordTest() {

        openBrowser();

        page.login("eu@fast.com", "eu.pass123");

        WebElement errorElement = driver.findElement(By.className("error-msg"));
        System.out.println(errorElement.getText());
        Assert.assertEquals(errorElement.getText(), "Invalid user or password!");


    }

    private void login(String user, String pass) {

        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passField = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));

        emailField.sendKeys(user);
        passField.sendKeys(pass);
        loginBtn.click();


    }




}
