package org.fasttrackit.Automation;


import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.automation.ChangePasswordPage;
import org.fasttrackit.automation.LoginPage;
import org.fasttrackit.util.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChangePasswordTest extends TestBase {

    private LoginPage loginPage;

    private ChangePasswordPage changePasswordPage;

    public ChangePasswordTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
    }

    @Test
    public void changePasswordWithInvalidCurrentPassword() {

        openPage();
        changePasswordPage.changePassword("wrong.pass", "new.pass", "new.pass");
        assertThat(changePasswordPage.getStatusMsg(), is("Your preview password is incorrect!"));
    }

    @Test
    public void changePasswordWithNotMatchingPasswords() {

        openPage();
        changePasswordPage.changePassword("eu.pass", "new1.pass", "new2.pass");
        assertThat(changePasswordPage.getStatusMsg(), is("Password does not match the confirm password!"));

    }

    private void openPage() {
        openBrowser();

        loginPage.login("eu@fast.com", "eu.pass");

        WebElement preferenceButton = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferenceButton.click();

        Utils.sleep(1000);
    }

}
