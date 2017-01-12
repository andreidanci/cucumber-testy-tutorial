package org.fasttrackit.Automation;


import org.fasttrackit.util.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends TestBase{

    @Test
    public void validLoginTest() {

        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passField =  driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));


        emailField.sendKeys("eu@fast.com");
        passField.sendKeys("eu.pass111");
        loginBtn.click();

     try {

         WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
         logoutBtn.click();
     } catch (NoSuchElementException er) {
         Assert.fail("Could not login. Logout button was not pressent!");

     }




    }


}
