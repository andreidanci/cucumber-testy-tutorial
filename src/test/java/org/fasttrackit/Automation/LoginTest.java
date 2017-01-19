package org.fasttrackit.Automation;


import org.fasttrackit.util.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends TestBase {

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

    private void openBrowser() {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }

    @Test
    public void invalidPasswordTest() {

        openBrowser();

        login("eu@fast.com", "eu.pass123");

        WebElement errorElement = driver.findElement(By.className("error-msg"));
        System.out.println(errorElement.getText());
        Assert.assertEquals(errorElement.getText(), "Invalid user or password!");


    }

    public void login(String user, String pass) {

        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passField = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));

        emailField.sendKeys(user);
        passField.sendKeys(pass);
        loginBtn.click();


    }

    @Test
    public void changePasswordWithInvalidCurrentPassword() {

        openBrowser();
        login("eu@fast.com", "eu.pass");

        WebElement preferenceButton = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferenceButton.click();

        WebElement currentPasswordField = driver.findElement(By.name("password"));
        WebElement newPasswordField = driver.findElement(By.name("newPassword"));
        WebElement repeatPasswordField = driver.findElement(By.name("newPasswordRepeat"));
        repeatPasswordField.sendKeys("new.pass");

        currentPasswordField.sendKeys("wrong.pass");
        newPasswordField.sendKeys("new.pass");


    }


}
