package org.fasttrackit.Automation;


import org.fasttrackit.automation.LoginView;
import org.fasttrackit.util.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginTest extends TestBase {

  //  private LoginPage page;
    private LoginView page = new LoginView();

    public LoginTest() {

      //  page = PageFactory.initElements(driver,LoginPage.class);

    }

    @Test
    public void validLoginTest() {

        openLoginPage();

        page.login("eu@fast.com", "eu.pass");

        try {

            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException er) {
            Assert.fail("Could not login. Logout button was not pressent!");

        }

    }



    @Test
    public void invalidPasswordTest() {

        openLoginPage();

        page.login("eu@fast.com", "eu.pass123");

        WebElement errorElement = driver.findElement(By.className("error-msg"));
        System.out.println(errorElement.getText());
        Assert.assertEquals(errorElement.getText(), "Invalid user or password!");


    }






}
